
import React, { useState, useEffect } from 'react'

import { Link, useParams, useNavigate } from 'react-router-dom';

import Service from './Service'


const AddProduct = () => {

    const [id, setId] = useState('');

    const [company, setCompany] = useState('')

    const [variant, setVariant] = useState('')

    const [price, setPrice] = useState('')

    const navigate = useNavigate();


    async function Addition(e) {

        e.preventDefault();

        Service.createProduct(company, variant, price).then((response) => {

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

                        <h2>ADD PRODUCT</h2>

                        <div className="card-body">

                            <form encType='multipart/form-data'>

                                <div className="form-group mb-2">

                                    <label className="form-label"> CompanyName</label>

                                    <input

                                        type="text"

                                        placeholder="Enter company name"

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

                                        placeholder="Enter Variant"

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

                                        name="price"

                                        className="form-control"

                                        value={price}

                                        onChange={(e) => setPrice(e.target.value)}

                                    >

                                    </input>

                                </div>


                                <button className="btn btn-success" onClick={(e) => Addition(e)} >Submit </button>

                                <Link to="/ProductsList" className="btn btn-danger"> Cancel </Link>

                            </form>

                        </div>

                    </div>

                </div>
            </div>

        </div>

    )

}

export default AddProduct;