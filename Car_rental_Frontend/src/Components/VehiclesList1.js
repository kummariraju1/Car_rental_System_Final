import React, { useEffect, useState } from "react";

import { Link, Navigate, useNavigate, useParams } from 'react-router-dom';

import Service from "./Service";
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';


const VehiclesList1 = () => {

    const [products, setProducts] = useState([])

    const id = localStorage.getItem('userid');
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

    const saveCart = (productId, id) => {



        Service.saveCart(productId, id).then((response) => {
            alert("item added to the cart")

        }).catch(error => {

            console.log(error);

        })

    }
    const logout = () => {

        localStorage.clear();
        navigate("/");
    }

    return (

        <div className="cars--card">

            <div className="container">

                <h2 className="text-center" style={{ color: 'white' }}>Cars</h2>

                {/* <Link to = "/addProduct" className = "btn btn-primary mb-2" > Add Product </Link> */}

                <button className="btn btn-danger" onClick={() => logout()}

                    style={{ marginLeft: "10px" }}> Logout</button>
                <Row xs={1} md={3} classname="g-4">

                    {
                        products.map(
                            (product, num) => (
                                <Col>
                                    <Card className="mb-5 mt-3">
                                        <Card.Body >
                                            <Card.Img src="https://mir-s3-cdn-cf.behance.net/project_modules/1400/34013a170417849.645d43f4154fe.png" alt="Card image" />

                                            <Card.Title>{product.company}</Card.Title>
                                            <Card.Text>{product.variant}

                                            </Card.Text>
                                            <Card.Text>{product.price}</Card.Text>
                                            <button className="btn btn-success" onClick={() => saveCart(product.id, id)}

                                                style={{ marginLeft: "180px" }}> AddItemToCart</button>

                                        </Card.Body>
                                    </Card>

                                </Col>

                            )

                        )

                    }

                </Row>
                <Link to={`/VehicleList3`} className="btn btn-primary mb-2" > View Cart</Link>

            </div>

        </div>
    )
}
export default VehiclesList1;