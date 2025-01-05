package com.example.backendtrial.product;

import com.example.backendtrial.product.model.Product;
import com.example.backendtrial.product.model.ProductDTO;
import com.example.backendtrial.product.model.UpdateProductCommand;
import com.example.backendtrial.product.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final CreateProductService createProductService;

    private final GetProductsService getProductsService;

    private final UpdateProductService updateProductService;

    private final DeleteProductService deleteProductService;

    private final GetProductService getProductService;

    private final SearchProductService searchProductService;

    public ProductController(CreateProductService createProductService,
                             GetProductsService getProductsService,
                             UpdateProductService updateProductService,
                             DeleteProductService deleteProductService,
                             GetProductService getProductService,
                             SearchProductService searchProductService) {
        this.createProductService = createProductService;
        this.getProductsService = getProductsService;
        this.updateProductService = updateProductService;
        this.deleteProductService = deleteProductService;
        this.getProductService = getProductService;
        this.searchProductService = searchProductService;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
        return createProductService.execute(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return getProductsService.execute(null);
    }

    // new mapping for find by Id
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id) {
        return getProductService.execute(id);
    }

    @GetMapping("/product/search")
    public ResponseEntity<List<ProductDTO>> searchProductByName(@RequestParam String name) {
        return searchProductService.execute(name);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id, @RequestBody Product product) {

        return updateProductService.execute(new UpdateProductCommand(id, product));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        return deleteProductService.execute(id);
    }
}
