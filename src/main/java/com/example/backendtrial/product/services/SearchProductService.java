package com.example.backendtrial.product.services;

import com.example.backendtrial.product.ProductRepository;
import com.example.backendtrial.Query;
import com.example.backendtrial.product.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchProductService implements Query<String, List<ProductDTO>> {

    private final ProductRepository productRepository;

    public SearchProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ResponseEntity<List<ProductDTO>> execute(String name) {
        // jpa
//        return ResponseEntity.ok(productRepository.findByNameContaining(name)

        // JPQL
        return ResponseEntity.ok(productRepository.findByNameOrDescriptionContaining(name)
                .stream()
                .map(ProductDTO::new)
                .toList());
    }
}
