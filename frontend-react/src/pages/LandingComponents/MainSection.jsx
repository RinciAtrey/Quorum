import React from 'react'

const MainSection = () => {
  return (
    <div className="landing-page-content relative">
      {/* Background — absolutely positioned behind the content */}
      <div className="absolute inset-0 bg-gradient-to-r from-purple-50 to-indigo-50 opacity-80 z-0 pointer-events-none" />

      {/* Actual content — sibling, above the bg */}
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 relative z-10">
        <div className="pt-20 pb-16 sm:pb-20 lg:pt-32 lg:pb-28">
          <div className="text-center">
            <h1 className="text-4xl tracking-tight font-extrabold text-gray sm:text-5xl md:text-6xl">
              <span className='block'>Create shareable presentations</span>
              <span className='block text-purple-500'>Quorum</span>
            </h1>
            <p className='mt-3 max-w-md mx-auto text-base text-gray-500 sm:text-lg md:mt-5 md:text-xl md:max-w-3xl'>
              Upload, manage and share your files securely. Accessible anywhere, anytime.
            </p>
            <div className="mt-10 max-w-sm mx-auto sm:max-w-none sm:flex sm:justify-center">
              <div className="space-y-4 sm:space-y-0 sm:mx-auto sm:inline-grid sm:grid-cols-2 sm:gap-5">
                <button className='flex items-center px-6 py-3 border border-transparent text-base font-medium rounded-md text-white bg-purple-500 hover:bg-purple-700 md:py-4 md:text-lg md:px-10 transition-all duration-200 shadow-lg hover:shadow-xl'>
                  Get Started
                </button>
                <button className="flex items-center justify-center px-6 py-3 border border-gray-300 text-base font-medium rounded-md text-black bg-white hover:bg-gray-200 md:py-4 md:text-lg md:px-10 transition-all duration-200 shadow-lg hover:shadow-xl'">Sign In</button>
              </div>
            </div>
          </div>
        </div>

        <div className="relative">
            <div className="aspect-w-16 rounded-lg shadow-xl overflow-hidden">
              <img src="https://img.freepik.com/free-vector/dashboard-interface-design-template_52683-22830.jpg" alt="cloudshae dashboard" className="w-full h-full object-cover" />
            </div>
            <div className="absolute inset-0 bg-gradient-to-t from-black opacity-10 rounded-lg"></div>
        </div>
        <div className="mt-8 text-center">
           <p className="mt-4 text-base text-gray-500 mb-8">
            All your files are encrypted and stored securely with enterprice-grad security protocols.
           </p>
        </div>
      </div>

      
    </div>
  )
}

export default MainSection
