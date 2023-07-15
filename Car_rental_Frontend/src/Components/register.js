import React, { useState } from "react"

import 'bootstrap/dist/css/bootstrap.min.css';

import axios from "axios";

import { useNavigate } from "react-router-dom";
import swal from 'sweetalert';


export default function (props) {

  const [id, setId] = useState("");

  const [fname, setFname] = useState("");

  const [lname, setLname] = useState("");

  const [passw, setPassw] = useState("");

  const [email, setEmail] = useState("");


  const navigate = useNavigate();


  async function save(event) {

    event.preventDefault();

    try {

      await axios.post("http://localhost:8099/saveUser",
        {

          firstname: fname,

          lastname: lname,

          password: passw,

          email: email

        }).then((res) => {

          console.log(res.data);

          if (res.data === "not") {
            swal("Good Job!", "You registered sucessfully!", "success");

            setFname("");

            setLname("");

            setEmail("");

            setPassw("");

            navigate("/login")

          }

          else if (res.data = "Registered") {

            swal("Hey Buddy!", "Already Exists!", "info");

          }

        });

    }

    catch (err) {

      swal("Try Again!", "Could Not Register", "info");


    }

  }

  return (
    <div className="register--login" >
      <div className="form-container">


        <form className="login-form">

          <div className="form-content">

            <h3 className="form-title"> Register</h3>

            <div className="form-group mt-3">

              <label>First Name</label>

              <input

                type="text"

                className="form-control mt-1"

                pattern='[a-zA-Z]+'

                required

                placeholder="First Name"

                value={fname}

                onChange={(event) => { setFname(event.target.value); }}

              />

            </div>

            <div className="form-group mt-3">

              <label>Last Name</label>

              <input

                type="text"

                className="form-control mt-1"

                pattern='[a-zA-Z]+'

                required

                placeholder="Last Name"

                value={lname}

                onChange={(event) => { setLname(event.target.value); }}



              />

            </div>

            <div className="form-group mt-3">

              <label>Email address</label>

              <input

                type="email"

                className="form-control mt-1"

                placeholder="Email Address"

                pattern='[a-z0-9._%+-]+@[a-z0-9._%+-]+\.[a-z]{2,4}$'

                required

                value={email}

                onChange={(event) => { setEmail(event.target.value); }}

              />

            </div>

            <div className="form-group mt-3">

              <label>Password</label>

              <input

                type="password"

                className="form-control mt-1"

                placeholder="Password"




                value={passw}

                onChange={(event) => { setPassw(event.target.value); }}

              />

            </div>

            <div className="d-grid gap-2 mt-3">

              <button type="submit" className="btn btn-primary" onClick={save}>

                Submit

              </button>

            </div>

          </div>

        </form>

      </div>
    </div>

  )

}