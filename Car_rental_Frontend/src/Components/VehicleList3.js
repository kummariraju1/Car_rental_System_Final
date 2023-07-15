import React, { useEffect, useState } from "react";

import { Link, Navigate, useNavigate, useParams } from 'react-router-dom';

import Service from "./Service";

const VehicleList3 = () => {

    const [products, setProducts] = useState([])

    const id = localStorage.getItem('userid');
    const navigate = useNavigate();


    useEffect(() => {

        getProduct();

    }, [])

    const getProduct = () => {

        Service.getProduct1(id).then((response) => {

            if (response.data === "null") {

                console.log("null");

            }

            else {

                setProducts(response.data)

                console.log(response.data);

            }

        }).catch(error => {

            console.log(error);

        })

    }

    const deleteProduct = (productId) => {

        Service.deleteProduct1(productId).then((response) => {

            getProduct();



        }).catch(error => {

            console.log(error);

        })



    }
    const logout = () => {

        localStorage.clear();
        navigate("/");
    }

    return (
        <div className="cart--page">
            <div className="container">

                <h2 className="text-center">Cart</h2>


                {/* <Link to = "/addProduct" className = "btn btn-primary mb-2" > Add Product </Link> */}

                <table className="table table-bordered table-stripped bg-info">

                    <thead>

                        <th>user_id</th>

                        <th>Car_Id</th>

                        <th>CompanyName</th>

                        <th>Variant</th>

                        <th>Price</th>



                    </thead>

                    <tbody>

                        {

                            products.map(

                                (product) => (

                                    <tr key={product.id}>

                                        <td>{id}</td>
                                        <td>{product.id}</td>
                                        <td>{product.company}</td>
                                        <td>{product.variant}</td>
                                        <td>{product.price}</td>
                                        <td>

                                            {/* <Link className="btn btn-info" to={`/updateproduct/`+product.id} >Update</Link> */}

                                            <button className="btn btn-danger" onClick={() => deleteProduct(product.id)}

                                                style={{ marginLeft: "10px" }}> Remove Item From cart</button>

                                        </td>

                                    </tr>
                                ))

                        }

                    </tbody>

                </table>

                <Link to={`/BookingReport`} className="btn btn-danger mb-2" > Book </Link>
                <button className="btn btn-danger" onClick={() => logout()} style={{ marginLeft: "950px" }}> Logout</button>

            </div>
        </div>
    )

}

export default VehicleList3;