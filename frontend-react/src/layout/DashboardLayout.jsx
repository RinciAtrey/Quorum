import Navbar from '../components/NavBar'
import SideMenu from '../components/SideMenu'

const DashboardLayout = ({ children, activeMenu }) => {
  return (
    // change to column so Navbar sits on top and spans full width
    <div className="flex flex-col min-h-screen">
      <Navbar activeMenu={activeMenu}/>

      {/* main content row below the navbar */}
      <div className="flex w-full">
        <div className="max-[1080]:hidden">
          <SideMenu activeMenu={activeMenu}/>
        </div>

        <div className="grow mx-5">
          {children}
        </div>
      </div>
    </div>
  )
}

export default DashboardLayout
