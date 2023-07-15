
import React, { useEffect, useState } from "react";

import { Link, Navigate, useNavigate, useParams } from 'react-router-dom';

import Service from "./Service";

const BookingReport = () => {

    const [product, setProduct] = useState([])

    const id = localStorage.getItem('userid');
    const navigate = useNavigate();

    useEffect(() => {

        getProduct();

    }, [])

    const getProduct = () => {

        Service.getProduct2(id).then((response) => {

            setProduct(response.data)

            console.log(response.data);

        }).catch(error => {

            console.log(error);

        })

    }
    const getPayment = () => {
        Service.deleteItems(id);
        navigate("/");
    }

    const logout = () => {
        localStorage.clear();
        navigate("/");
    }


    return (

        <div className="container">

            <h2 className="text-center">Final Booking Report</h2>
            <button className="btn btn-danger" onClick={() => getPayment(product.id)} style={{ marginLeft: "70px" }}>Continue Ordering</button>
            <button className="btn btn-danger" onClick={() => logout()} style={{ marginLeft: "750px" }}> Logout</button>
            {/* <Link to = "/addProduct" className = "btn btn-primary mb-2" > Add Product </Link> */}


            <div className="booking--report">
                <p> Booking Id : {product.bid}</p>

                <p> User ID : {product.uid}</p>

                <p> Final Price : {product.finalprice}</p>

            </div>
        </div>

    )

}

export default BookingReport;