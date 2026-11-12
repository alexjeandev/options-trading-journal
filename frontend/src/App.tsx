import {Route, Routes} from "react-router-dom";
import LandingPage from "./pages/LandingPage.tsx";
import Dashboard from "./pages/Dashboard.tsx";

function App() {
  return (
      <Routes>
          <Route path="/" element={<LandingPage />} />
          <Route path="/dashboard" element={<Dashboard />} />
      </Routes>
  )
}

export default App