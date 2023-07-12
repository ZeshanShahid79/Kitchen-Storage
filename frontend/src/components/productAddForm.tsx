import {ChangeEvent, FormEvent, useState} from 'react';
import axios from "axios";
import {Product} from "../Product.ts";
import {toast} from "react-toastify";
import { Button, TextField} from "@mui/material";

function ProductAddForm() {

    const [productName, setProductName] = useState<string>("")

    const addProduct = (): void => {
        axios.post("api/products", {productName:productName})
            .then(response => {
                const responseData = response.data as Product
                setProductName(responseData.productName);
            })
            .then(() => {
                toast.success("Added: " + productName)
            })
            .catch(() => {
                toast.error("Error adding product")
            }).finally(() => setProductName(""))

    }

    function handleProductNameInput(event: ChangeEvent<HTMLInputElement>) {
        setProductName(event.target.value)
    }

    function handleSubmit(event: FormEvent<HTMLFormElement>) {
        event.preventDefault()
        addProduct()

    }

    return (
        <form onSubmit={handleSubmit}>

            <TextField value={productName} onChange={handleProductNameInput} label={"ProductName"} size={"small"} />
            <Button variant={"contained"} size={"large"}>Add</Button>

        </form>
    );
}

export default ProductAddForm;
