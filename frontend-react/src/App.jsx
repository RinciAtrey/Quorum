import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import LoginPage from './components/LoginPage'
import SignUpPage from './components/SignupPage'
import LandingPage from './pages/LandingPage'
import Dashboard from './pages/Dashboard'
import MyProjects from './pages/MyProjects'

function App() {
  return (
    <Router>  
      <Routes>
         <Route path="/" element={<Dashboard/>} />
        {/* <Route path="/" element={<LandingPage/>} /> */}
        <Route path="/login" element={<LoginPage />} />
        <Route path="/signup" element={<SignUpPage />} />
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/projects" element={<MyProjects />} />
      </Routes>
    </Router>
  )
}

export default App
