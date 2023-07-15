import React from "react";

import 'bootstrap/dist/css/bootstrap.min.css';

import Container from 'react-bootstrap/Container';

import Nav from 'react-bootstrap/Nav';

import Navbar from 'react-bootstrap/Navbar';
import CarSlider from "./CarSlider";
import { useState } from "react";

const Home = () => {

  return (

    <>

      <Navbar bg="info" variant="light">

        <Container>

          <Navbar.Brand href="/">VEHICLE RENTAL</Navbar.Brand>

          <Nav className="me-auto">

            <Nav.Link href="./register">Register</Nav.Link>

            <Nav.Link href="./login">UserLogin</Nav.Link>

            <Nav.Link href="./adminlogin">AdminLogin</Nav.Link>


          </Nav>

        </Container>

      </Navbar>

    </>

  )

}

export default Home;