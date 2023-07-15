
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from './Components/Home';
import Register from './Components/register';
import Login from './Components/login';
import Adminlogin from "./Components/Adminlogin";
import VehiclesList from "./Components/VehiclesList";
import VehiclesList1 from "./Components/VehiclesList1";
import Service from "./Components/Service";
import AddProduct from "./Components/AddProduct";
import UpdateProduct from "./Components/Updateproduct";
import VehicleList3 from "./Components/VehicleList3";
import './App.css';
import BookingReport from "./Components/BookingReport";
import CarSlider from "./Components/CarSlider";



function App() {
  return (
    <>
      <Home />
      <BrowserRouter>

        <Routes>

          <Route path="/" element={<CarSlider />} />
          <Route path="/register" element={<Register />} />
          <Route path="/login" element={<Login />} />
          <Route path="/adminlogin" element={<Adminlogin />} />
          <Route path="/VehiclesList" element={<VehiclesList />} />
          <Route path="/VehiclesList1" element={<VehiclesList1 />} />
          <Route path="/Service" element={<Service />} />
          <Route path="/addProduct" element={<AddProduct />} />
          <Route path="/VehicleList3" element={<VehicleList3 />} />
          <Route path="/updateproduct/:id" element={<UpdateProduct />} />
          <Route path="/BookingReport" element={<BookingReport />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
