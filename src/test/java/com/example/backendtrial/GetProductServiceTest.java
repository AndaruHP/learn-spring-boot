package com.example.backendtrial;

import com.example.backendtrial.product.ProductRepository;
import com.example.backendtrial.exceptions.ProductNotFoundException;
import com.example.backendtrial.product.model.Product;
import com.example.backendtrial.product.model.ProductDTO;
import com.example.backendtrial.product.services.GetProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class GetProductServiceTest {

    @Mock //dependency to run test
    private ProductRepository productRepository;

    @InjectMocks
    private GetProductService getProductService;

    @BeforeEach // things we need before test runs to set up properly
    public void setUp() {
        // initialize the repository and service
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_product_exists_when_getProduct_then_return_product_dto() {
        // given
        Product product = new Product();
        product.setId(1);
        product.setName("test");
        product.setDescription("description");
        product.setPrice(9.99);

        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        // when
        ResponseEntity<ProductDTO> response = getProductService.execute(1);

        assertEquals(ResponseEntity.ok(new ProductDTO(product)), response);
        verify(productRepository, times(1)).findById(1);
    }

    @Test
    public void given_product_does_not_exist_when_get_product_service_throw_product_not_found_exception() {
        // given
        when(productRepository.findById(1)).thenReturn(Optional.empty());

        // when and then
        assertThrows(ProductNotFoundException.class, () -> getProductService.execute(1));
        verify(productRepository, times(1)).findById(1);
    }
}
