import React, { useState, useEffect } from 'react'

import { Link, Navigate, useNavigate, useParams } from 'react-router-dom';

import Service from './Service'




const UpdateProduct = () => {

    const [company, setCompany] = useState('')

    const [variant, setVariant] = useState('')

    const [price, setPrice] = useState('')

    const { id } = useParams();

    const navigate = useNavigate();

    useEffect(() => {

        Service.getProductById(id).then((response) => {

            console.log(response)

            setCompany(response.data.company)

            setVariant(response.data.variant)

            setPrice(response.data.price)

        }).catch((err) => {

            console.log(err)

        })

    }, [])

    async function Updation(e) {

        e.preventDefault();

        Service.updateProduct(id, company, variant, price).then((response) => {

            console.log(response);

            navigate('/VehiclesList')

        }).catch((err) => {

            console.log(err)

        })

    }

    return (

        <div>

            <br /><br />

            <div className="container">

                <div className="row">

                    <div className="card col-md-6 offset-md-3 offset-md-3">

                        <h2>Update Product</h2>

                        <div className="card-body">

                            <form encType='multipart/form-data'>



                                <div className="form-group mb-2">

                                    <label className="form-label"> Company Name</label>

                                    <input

                                        type="text"

                                        placeholder="Enter Company name"

                                        name="footwearname"

                                        className="form-control"

                                        value={company}

                                        onChange={(e) => setCompany(e.target.value)}

                                    >

                                    </input>

                                </div>

                                <div className="form-group mb-2">

                                    <label className="form-label"> Variant :</label>

                                    <input

                                        type="text"

                                        placeholder="Enter variant"

                                        name="brandname"

                                        className="form-control"

                                        value={variant}

                                        onChange={(e) => setVariant(e.target.value)}

                                    >
                                    </input>

                                </div>
                                <div className="form-group mb-2">

                                    <label className="form-label"> Price</label>

                                    <input

                                        type="number"

                                        placeholder="Enter the Price"

                                        pattern="^(?!.*[-+])[0-9]*$"

                                        min="0"

                                        name="price"

                                        className="form-control"

                                        value={price}

                                        onChange={(e) =>  setPrice(e.target.value)}

                                    >

                                    </input>

                                </div>

                                <button className="btn btn-success" onClick={(e) => Updation(e)} >Submit </button>

                                <Link to="/VehiclesList" className="btn btn-danger"> Cancel </Link>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    )

}

export default UpdateProduct;