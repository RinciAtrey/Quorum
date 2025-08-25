import React from 'react'
import MainSection from './LandingComponents/MainSection'
import CTASection from './LandingComponents/CTASection'
import Footer from './LandingComponents/Footer'

const LandingPage = () => {
  return (
    <div className='landing-page bg-gradient-to-b from-gray-50 to-gray-100 '>
    <MainSection/>
    <CTASection/>
    <Footer/>
    </div>
  )
}

export default LandingPage
