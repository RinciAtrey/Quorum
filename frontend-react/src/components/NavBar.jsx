import { Menu, Share2, Wallet, X } from "lucide-react";
import { useState } from "react";
import { Link } from "react-router-dom";
import SideMenu from "./SideMenu";

const Navbar = ({activeMenu}) => {
  const [openSideMenu, setOpenSideMenu] = useState(false);

  return (
    // make navbar span viewport width and be sticky
    <div className="w-full flex items-center gap-5 bg-white border border-gray-200/50 backdrop-blur-[2px] py-4 px-4 sm:px-7 sticky top-0 left-0 right-0 z-30">
      {/* Left side - menu button and title */}
      <div className="flex items-center gap-5">
        <button
          onClick={() => setOpenSideMenu(!openSideMenu)}
          className="block lg:hidden text-black hover:bg-gray-100 p-1 rounded transition-colors"
          aria-label="Toggle menu"
        >
          {openSideMenu ? <X className="text-2xl" /> : <Menu className="text-2xl" />}
        </button>

        <div className="flex items-center gap-2">
          <Share2 className="text-blue-600" />
          <span className="text-lg font-medium text-black truncate">Quorum</span>
        </div>
      </div>

      {/* Right side - push to extreme right with ml-auto */}
      <div className="ml-auto flex items-center gap-4">
        <Link to={"/dashboard"}>
        </Link>
      </div>


      {/* Mobile side menu */}
      {openSideMenu && (
        <div className="fixed top-[73px] left-0 right-0 bg-white border-b border-gray-200 lg:hidden z-20" >
          <SideMenu activeMenu={activeMenu}/>
           </div>
      )}
    </div>

    


  );
};

export default Navbar;
