import React, { useState } from "react"

import 'bootstrap/dist/css/bootstrap.min.css'

import { BrowserRouter, Routes, Route, useNavigate } from "react-router-dom";

import axios from "axios";
import swal from "sweetalert";

export default function (props) {


  const [email, setEmail] = useState("");

  const [passw, setPassw] = useState("");

  const navigate = useNavigate();

  async function check(event) {

    event.preventDefault();

    try {

      await axios.post("http://localhost:8101/adminvalidation", {

        uname: email,

        password: passw,

      }).then((res) => {
        console.log(res.data);
        var a = res.data;
        var c = a.substring(0, 5);
        var d = a.substring(5, 7);



        if (c === "valid") {
          console.log("hello");
          swal("Good Job!", "You loggedn sucessfully!", "success");
          localStorage.setItem('adminid', d);
          navigate("/VehiclesList")

        }

        else if (res.data === "Invalid") {

          swal("Hey there!", "Invalid Credentials.", "info");


        }

        else {

          alert("Password and email does not exist");



        }

      }, fail => {

        console.error(fail);

      });

    }

    catch (err) {

      alert("Could not login");

    }

  }

  return (
    <div className="register--login" >

      <div className="form-container" >

        <form className="login-form">

          <div className="form-content">

            <h3 className="form-title">Admin Login</h3>

            <div className="form-group mt-3">

              <label>User Name</label>

              <input

                type="email"

                className="form-control mt-1"

                placeholder="Enter email"

                value={email}

                onChange={(event) => { setEmail(event.target.value); }}

              />

            </div>

            <div className="form-group mt-3">

              <label>Password</label>

              <input

                type="password"

                className="form-control mt-1"

                placeholder="Enter password"

                value={passw}

                onChange={(event) => { setPassw(event.target.value); }}

              />

            </div>

            <div className="d-grid gap-2 mt-3">

              <button type="submit" className="btn btn-primary" onClick={check}>

                Submit

              </button>

            </div>

          </div>

        </form>

      </div>
    </div>
  )
}