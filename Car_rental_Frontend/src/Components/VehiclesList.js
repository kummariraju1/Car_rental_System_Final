import React, { useEffect, useState } from "react";

import { Link, Navigate, useNavigate } from 'react-router-dom'

import Service from "./Service";

const VehiclesList = () => {

    const [products, setProducts] = useState([])
    const navigate = useNavigate();

    useEffect(() => {

        getProduct();

    }, [])

    const getProduct = () => {

        Service.getProduct().then((response) => {

            setProducts(response.data)

            console.log(response.data);

        }).catch(error => {

            console.log(error);

        })

    }

    const deleteProduct = (productId) => {

        Service.deleteProduct(productId).then((response) => {

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
        <div className="add--cars">
            <div className="container">

                <h2 className="text-center">Cars</h2>

                <Link to="/addProduct" className="btn btn-primary mb-2" > Add Product </Link>
                <button className="btn btn-danger" onClick={() => logout()} style={{ marginLeft: "10px" }}> Logout</button>

                <table className="table table-bordered table-stripped bg-danger">

                    <thead>

                        <th>Car_Id</th>

                        <th>CompanyName</th>

                        <th>Variant</th>

                        <th>Price</th>



                    </thead>

                    <tbody>

                        {

                            products.map(

                                (product, num) => (

                                    <tr key={product.id}>

                                        <td>{product.id}</td>

                                        <td>{product.company}</td>

                                        <td>{product.variant}</td>

                                        <td>{product.price}</td>




                                        <td>

                                            <Link className="btn btn-info" to={`/updateproduct/` + product.id} >Update</Link>

                                            <button className="btn btn-danger" onClick={() => deleteProduct(product.id)}

                                                style={{ marginLeft: "10px" }}> Delete</button>

                                        </td>

                                    </tr>




                                ))

                        }

                    </tbody>

                </table>




            </div>

        </div>


    )

}

export default VehiclesList;