import React from "react";

import { Carousel } from "react-bootstrap";

import Footer from "./Footer";


const CarSlider = () => {

  return (

    <>

      <Carousel>

        <Carousel.Item interval={300}>

          <img

            className="d-block w-100"

            src="https://mir-s3-cdn-cf.behance.net/project_modules/1400/2bc539165098821.640184e5399c5.jpg"

            alt="First slide"

          />

          <Carousel.Caption>

            <h3>Afforable Prices</h3>

            <p>Renting out Super Cars at affordable prices.</p>

          </Carousel.Caption>

        </Carousel.Item>

        <Carousel.Item interval={100}>

          <img

            height={650}

            className="d-block w-100"

            src="https://mir-s3-cdn-cf.behance.net/project_modules/1400/dc47e6165098821.640184e53cdf1.jpg"

            alt="Second slide"

          />

          <Carousel.Caption>

            <h3>Super Cars at Low Prices</h3>

            <p>For those who dare to speed.</p>

          </Carousel.Caption>

        </Carousel.Item>

        <Carousel.Item>

          <img

            height={650}

            className="d-block w-100"

            src="https://mir-s3-cdn-cf.behance.net/project_modules/1400/1d4ded165098821.640184e538c84.jpg"

            alt="Third slide"

          />

          <Carousel.Caption>

            <h3>Cars at your Doorstep</h3>

            <p>

              On booking delivery be at your doorstep.

            </p>

          </Carousel.Caption>

        </Carousel.Item>

      </Carousel>

      <Footer />

    </>

  )

}

export default CarSlider;