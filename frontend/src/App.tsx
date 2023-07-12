import {useProducts} from "./hooks/useProducts.tsx";
import {ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import ProductAddForm from "./components/productAddForm.tsx";
import {List, ListItemAvatar, Stack} from "@mui/material";


function App() {

    const {products} = useProducts()

    return (
        <>
            <Stack alignItems={"center"}>
                <h1>Kitchen Storage</h1>
                <h3>Product List:</h3>
                <List dense={true}>
                    {products.map(product => (
                        <ListItemAvatar sx={{border: 1, m: 2, p: 2}}
                                        key={product.id}>{product.productName}</ListItemAvatar>
                    ))}
                </List>
                <ProductAddForm/>
                <ToastContainer/>
            </Stack>
        </>
    );
}

export default App;
