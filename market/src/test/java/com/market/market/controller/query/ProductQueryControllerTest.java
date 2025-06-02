package com.market.market.controller.query;

import com.market.market.model.response.ProductResponse;
import com.market.market.service.IProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



class ProductQueryControllerTest {

    private IProductService productService;
    private ProductQueryController controller;

    @BeforeEach
    void setUp() {
        productService = mock(IProductService.class);
        controller = new ProductQueryController(productService);
    }

    @Test
    void getAllProductsReturnsProductList() {
        ProductResponse product1 = new ProductResponse();
        ProductResponse product2 = new ProductResponse();
        List<ProductResponse> mockProducts = Arrays.asList(product1, product2);

        when(productService.getAllProducts()).thenReturn(mockProducts);

        List<ProductResponse> result = controller.getAllProducts(10, 0);

        assertEquals(2, result.size());
        assertSame(product1, result.get(0));
        assertSame(product2, result.get(1));
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void getAllProductsReturnsEmptyList() {
        when(productService.getAllProducts()).thenReturn(Collections.emptyList());

        List<ProductResponse> result = controller.getAllProducts(5, 2);

        assertTrue(result.isEmpty());
        verify(productService, times(1)).getAllProducts();
    }
}