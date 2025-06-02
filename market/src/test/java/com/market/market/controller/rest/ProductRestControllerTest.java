package com.market.market.controller.rest;


import com.market.market.model.response.ProductResponse;
import com.market.market.service.IProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class ProductRestControllerTest {

    private IProductService productService;
    private ProductRestController productRestController;

    @BeforeEach
    void setUp() {
        productService = mock(IProductService.class);
        productRestController = new ProductRestController(productService);
    }

    @Test
    void getAllProductsReturnsListOfProductResponses() {
        var products = List.of(
            mock(ProductResponse.class), 
            mock(ProductResponse.class));

        when(productService.getAllProducts()).thenReturn(products);

        ResponseEntity<List<ProductResponse>> response = productRestController.getAllProducts();

        assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
        assertEquals(products, response.getBody());
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void getAllProductsReturnsEmptyList() {
        when(productService.getAllProducts()).thenReturn(Collections.emptyList());

        ResponseEntity<List<ProductResponse>> response = productRestController.getAllProducts();

        assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
        assertTrue(response.getBody().isEmpty());
        verify(productService, times(1)).getAllProducts();
    }
}
