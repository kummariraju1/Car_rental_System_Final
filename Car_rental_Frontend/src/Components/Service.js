import axios from 'axios';

const getburl = "http://localhost:8102";

const getburl1 = "http://localhost:8103";


class Service {

    getProduct() {

        return axios.get("http://localhost:8102/");

    }

    getProduct1(id) {

        return axios.get("http://localhost:8103/getall/" + id);

    }

    getProduct2(id) {

        return axios.post("http://localhost:8104/saveResponse/" + id);

    }


    createProduct(company, variant, price) {

        return axios.post("http://localhost:8102/saveVehicle",

            {

                company: company,

                variant: variant,

                price: price



            }

        )

    }


    getProductById(productId) {

        return axios.get(getburl + '/getproduct/' + productId);

    }




    updateProduct(id, company, variant, price) {
        

        return axios.put("http://localhost:8102/editVehicle/" + id,

            {

                company: company,

                variant: variant,

                price: price

            })

    }




    deleteProduct(productId) {

        return axios.delete(getburl + '/deleteVehicle/' + productId);

    }

    
    deleteProduct1(productId) {

        return axios.delete(getburl1 + '/deleteCart/' + productId);

    }

    
    deleteItems(id) {
        return axios.delete("http://localhost:8103/deleteall/" + id);
    }

    saveCart(id, uid) {

        return axios.post("http://localhost:8103/savevehicle/" + id + "/" + uid,

            {

                id: id,
                uid: uid
            }

        )

    }

}

export default new Service();
