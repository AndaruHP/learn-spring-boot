package com.example.backendtrial.product.services;

import com.example.backendtrial.Command;
import com.example.backendtrial.product.ProductRepository;
import com.example.backendtrial.exceptions.ProductNotFoundException;
import com.example.backendtrial.product.model.Product;
import com.example.backendtrial.product.model.ProductDTO;
import com.example.backendtrial.product.model.UpdateProductCommand;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO> {

    private ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @CachePut(value = "productCache", key="#command.getId()")
    // Evict -> throws it away only
    // Put -> throws it away then puts the return value of the method in the cache
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
        Optional<Product> productOptional = productRepository.findById(command.getId());
        if (productOptional.isPresent()) {
            Product product = command.getProduct();
            product.setId(command.getId());
//            ProductValidator.execute(product);
            // we can use ProductValidator, but in this case we change we use spring-boot-starter-validation in Product
            productRepository.save(product);
            return ResponseEntity.ok(new ProductDTO(product));
        }

        throw new ProductNotFoundException();
    }
}
