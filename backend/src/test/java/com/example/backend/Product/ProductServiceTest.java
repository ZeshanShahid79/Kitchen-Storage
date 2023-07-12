package com.example.backend.Product;

import com.example.backend.products.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    ProductRepository productRepository = mock(ProductRepository.class);
    UuidService uuidService = mock(UuidService.class);
    ProductService productService = new ProductService(productRepository,uuidService);

    @Test
    void getAllProductsAndExpectListWithProduct() {
        //given
        Product testProduct = new Product("wqeasd", "apple");
        List<Product> expected = List.of(testProduct);
        //when
        when(productRepository.findAll()).thenReturn(expected);
        List<Product> actual = productService.getAllProducts();
        //then
        assertEquals(expected,actual);

    }

    @Test
    void addProductAndExpectTheAddedProduct() {
        //given
        Product expected = new Product("wqeasd", "apple");
        ProductWithouthId testProductWothouthId = new ProductWithouthId("apple");
        //then
        when(uuidService.getRandomId()).thenReturn("wqeasd");
        when(productRepository.save(expected)).thenReturn(expected);
        Product actual = productService.addProduct(testProductWothouthId);
        //then
        assertEquals(expected,actual);
    }
}
