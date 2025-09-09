import React from 'react'
import DashboardLayout from '../layout/DashboardLayout'

const Dashboard = ({ children }) => {
  return (
    <div className="w-full">
      <DashboardLayout activeMenu="Dashboard">
        {/* optional children content */}
      </DashboardLayout>
    </div>
  )
}

export default Dashboard
