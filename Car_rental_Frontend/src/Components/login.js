import React, { useState } from "react"

import 'bootstrap/dist/css/bootstrap.min.css'

import { BrowserRouter, Routes, Route, useNavigate } from "react-router-dom";

import { Alert, Container } from 'react-bootstrap';

import axios from "axios";
import swal from 'sweetalert';

export default function (props) {
  const [email, setEmail] = useState("");

  const [passw, setPassw] = useState("");

  const navigate = useNavigate();


  async function check(event) {

    event.preventDefault();

    try {

      await axios.post("http://localhost:8101/uservalidation", {

        uname: email,

        password: passw,

      }).then((res) => {

        console.log(res.data);
        var a = res.data;
        var f = a.substring(0, 5);
        var g = a.substring(5, 7);

        if (f === "valid") {
          swal("Good Job!", "You logged sucessfully!", "success");
          localStorage.setItem('userid', g);
          navigate("/VehiclesList1");


        }

        else if (res.data === "not valid") {

          swal("Hey there!", "Invalid Credentials.", "info");

        }



      }, fail => {

        console.error(fail);

      });

    }

    catch (err) {

      swal("Hey there!", "Invalid Credentials.", "info");


    }

  }

  return (
    <div className="register--login" >

      <div className="form-container" >

        <form className="login-form">

          <div className="form-content">

            <h3 className="form-title">Login</h3>

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