package com.example.backend.products;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final UuidService uuidService;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(ProductWithouthId productWithouthId) {
        String id = uuidService.getRandomId();
        Product productToSave = new Product(id, productWithouthId.productName());
        return productRepository.save(productToSave);
    }
}
