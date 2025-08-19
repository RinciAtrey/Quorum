import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import api from "../api/api";

const SignUpPage = () => {
  const navigate = useNavigate();
  const [loader, setLoader] = useState(false);
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const validateEmail = (e) =>
    /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(e);

  const signupHandler = async (e) => {
    e.preventDefault();
    setError("");

    if (!username.trim() || !email.trim() || !password) {
      setError("Please fill username, email and password.");
      return;
    }
    if (!validateEmail(email.trim())) {
      setError("Please enter a valid email address.");
      return;
    }

    setLoader(true);
    try {
      const payload = {
        username: username.trim(),
        email: email.trim(),
        password,
      };

      const { data } = await api.post("/api/auth/register", payload);

      console.log("Signup success:", data);
      navigate("/login");
    } catch (err) {
      console.error("signupHandler error:", err);
      const serverMessage =
        err?.response?.data?.message ||
        (typeof err?.response?.data === "string" && err.response.data) ||
        err?.message ||
        "Signup failed. Please try again.";

      setError(serverMessage);
    } finally {
      setLoader(false);
    }
  };

  return (
    <div className="min-h-screen bg-gray-100 text-gray-900 flex justify-center">
      <div className="max-w-screen-xl m-0 sm:m-10 bg-white shadow sm:rounded-lg flex w-full">
        <div className="hidden lg:flex lg:w-1/2 bg-indigo-100 items-center justify-center">
          <div
            className="m-12 xl:m-16 w-full bg-contain bg-center bg-no-repeat"
            style={{
              backgroundImage:
                "url('https://storage.googleapis.com/devitary-image-host.appspot.com/15848031292911696601-undraw_designer_life_w96d.svg')",
            }}
            role="img"
            aria-label="Designer illustration"
          />
        </div>

        <div className="w-full lg:w-1/2 p-6 sm:p-12 flex items-center justify-center">
          <div className="w-full max-w-md">
            <div className="flex justify-center">
              <img
                src="https://images.app.goo.gl/Rmzb8E3uVYqeunzw5"
                className="w-32"
                alt="Logo"
              />
            </div>

            <div className="mt-8">
              <h1 className="text-2xl xl:text-3xl font-bold text-center">Sign up</h1>

              <div className="w-full flex-1 mt-6">
                <div className="my-12 border-b text-center">
                  <div className="leading-none px-2 inline-block text-sm text-gray-600 tracking-wide font-medium bg-white transform translate-y-1/2">
                    Or sign up with e-mail
                  </div>
                </div>

                <form className="mx-auto max-w-xs" onSubmit={signupHandler} noValidate>
                  {error && (
                    <div className="mb-4 text-sm text-red-600 bg-red-50 border border-red-100 px-3 py-2 rounded">
                      {error}
                    </div>
                  )}

                  <input
                    className="w-full px-8 py-4 rounded-lg font-medium bg-gray-100 border border-gray-200 placeholder-gray-500 text-sm focus:outline-none focus:border-gray-400 focus:bg-white"
                    type="text"
                    placeholder="Username"
                    aria-label="Username"
                    required
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                  />

                  <input
                    className="w-full px-8 py-4 rounded-lg font-medium bg-gray-100 border border-gray-200 placeholder-gray-500 text-sm focus:outline-none focus:border-gray-400 focus:bg-white mt-5"
                    type="email"
                    placeholder="Email"
                    aria-label="Email"
                    required
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                  />

                  <input
                    className="w-full px-8 py-4 rounded-lg font-medium bg-gray-100 border border-gray-200 placeholder-gray-500 text-sm focus:outline-none focus:border-gray-400 focus:bg-white mt-5"
                    type="password"
                    placeholder="Password"
                    aria-label="Password"
                    required
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                  />

                  <button
                    type="submit"
                    disabled={loader}
                    className={`mt-5 tracking-wide font-semibold ${
                      loader ? "bg-indigo-300" : "bg-indigo-500 hover:bg-indigo-700"
                    } text-gray-100 w-full py-4 rounded-lg transition-all duration-300 ease-in-out flex items-center justify-center focus:shadow-outline focus:outline-none`}
                  >
                    {loader ? (
                      <svg
                        className="w-6 h-6 -ml-2 animate-spin"
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                        aria-hidden="true"
                      >
                        <circle
                          className="opacity-25"
                          cx="12"
                          cy="12"
                          r="10"
                          stroke="currentColor"
                          strokeWidth="4"
                        />
                        <path
                          className="opacity-75"
                          fill="currentColor"
                          d="M4 12a8 8 0 018-8v4a4 4 0 00-4 4H4z"
                        />
                      </svg>
                    ) : (
                      <svg
                        className="w-6 h-6 -ml-2"
                        fill="none"
                        stroke="currentColor"
                        strokeWidth="2"
                        strokeLinecap="round"
                        strokeLinejoin="round"
                        aria-hidden="true"
                        focusable="false"
                        viewBox="0 0 24 24"
                      >
                        <path d="M16 21v-2a4 4 0 00-4-4H5a4 4 0 00-4 4v2" />
                        <circle cx="8.5" cy="7" r="4" />
                        <path d="M20 8v6M23 11h-6" />
                      </svg>
                    )}
                    <span className="ml-3">{loader ? "Signing up..." : "Sign Up"}</span>
                  </button>

                  <p className="mt-6 text-xs text-gray-600 text-center">
                    Already have an account?{" "}
                    <Link to="/login" className="border-b border-gray-500 border-dotted text-blue-500">
                      Login
                    </Link>
                  </p>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default SignUpPage;
