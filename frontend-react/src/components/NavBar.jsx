import { useState } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";


const Navbar = () => {



  return (
   <div className="min-h-screen bg-gray-50 text-gray-900 antialiased">
      <header className="max-w-7xl mx-auto px-6 py-6 flex items-center justify-between">
        <div className="flex items-center gap-4">
          <div className="w-10 h-10 rounded-lg bg-gradient-to-r from-indigo-500 via-purple-500 to-pink-500 flex items-center justify-center text-white font-bold">MM</div>
          <nav className="hidden md:flex items-center gap-8 text-sm font-medium">
            <a href="#templates" className="hover:text-indigo-600">Templates</a>
            <a href="#how" className="hover:text-indigo-600">How it works</a>
            <a href="#pricing" className="hover:text-indigo-600">Pricing</a>
          </nav>
        </div>
        <div className="flex items-center gap-3">
          <button className="hidden sm:inline-flex items-center gap-2 px-3 py-2 rounded-md border border-gray-200 bg-white text-sm hover:shadow">Sign in</button>
          <button className="inline-flex items-center gap-2 px-4 py-2 rounded-lg bg-indigo-600 text-white font-semibold shadow hover:bg-indigo-700">Create presentation</button>
        </div>
      </header>
   </div>
  );
};

export default Navbar;