package com.example.backendtrial.product.services;

import com.example.backendtrial.product.ProductRepository;
import com.example.backendtrial.product.Query;
import com.example.backendtrial.product.model.Product;
import com.example.backendtrial.product.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsService implements Query<Void, List<ProductDTO>> {

    private final ProductRepository productRepository;

    public GetProductsService(ProductRepository productRepository)    {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> execute(Void input) {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = products.stream().map(ProductDTO::new).toList();

        // if there is nothing, is okay because maybe there are NOTHING
        return ResponseEntity.status(HttpStatus.OK).body(productDTOs);

    }
}
