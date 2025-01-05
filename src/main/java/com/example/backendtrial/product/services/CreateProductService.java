package com.example.backendtrial.product.services;

import com.example.backendtrial.Command;
import com.example.backendtrial.product.ProductRepository;
import com.example.backendtrial.product.model.Product;
import com.example.backendtrial.product.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements Command<Product, ProductDTO> {

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {
        // validate before saving
//        ProductValidator.execute(product);
        // we can use ProductValidator, but in this case we change we use spring-boot-starter-validation in Product
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));
    }
}
