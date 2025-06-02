package com.market.market.service;

import com.market.market.adapter.ProductAdapter;
import com.market.market.exception.NotFoundException;
import com.market.market.model.dto.ProductDto;
import com.market.market.model.entity.ProductEntity;
import com.market.market.model.response.ProductResponse;
import com.market.market.repository.ProductRepository;
import com.market.market.validator.ProductValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductAdapter productAdapter;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        // No-op, handled by @InjectMocks
    }

    @Test
    void getAllProductsReturnsProductResponses() {
        var entities = List.of(
            mock(ProductEntity.class), 
            mock(ProductEntity.class));
        var dtos = List.of(
            mock(ProductDto.class), 
            mock(ProductDto.class));
        var responses = List.of(
            mock(ProductResponse.class), 
            mock(ProductResponse.class));

        when(productRepository.findAll()).thenReturn(entities);
        when(productAdapter.fromEntityToDto(entities)).thenReturn(dtos);
        when(productAdapter.fromDtoToResponse(dtos)).thenReturn(responses);

        List<ProductResponse> result = productService.getAllProducts();

        assertEquals(responses, result);
        verify(productRepository).findAll();
        verify(productAdapter).fromEntityToDto(entities);
        verify(productAdapter).fromDtoToResponse(dtos);
    }

    @Test
    void getProductByIdWhenProductExistsReturnsProductResponse() {
        Long id = 1L;
        var entity = mock(ProductEntity.class);
        var dto = mock(ProductDto.class);
        var response = mock(ProductResponse.class);

        Optional<ProductEntity> entityOpt = Optional.of(entity);

        when(productRepository.findById(id)).thenReturn(entityOpt);
        when(productAdapter.fromEntityToDto(entity)).thenReturn(dto);
        when(productAdapter.fromDtoToResponse(dto)).thenReturn(response);

        try (MockedStatic<ProductValidator> validatorMock = mockStatic(ProductValidator.class)) {
            ProductResponse result = productService.getProductById(id);

            assertEquals(response, result);
            verify(productRepository).findById(id);
            validatorMock.verify(() -> ProductValidator.validateProductExists(entityOpt));
            verify(productAdapter).fromEntityToDto(entity);
            verify(productAdapter).fromDtoToResponse(dto);
        }
    }

    @Test
    void getProductByIdWhenProductDoesNotExistThrowsException() {
        Long id = 2L;
        Optional<ProductEntity> emptyOpt = Optional.empty();
        var entity = mock(ProductEntity.class);
        var dto = mock(ProductDto.class);

        doThrow(new NotFoundException("Product not found"))
                    .when(productRepository.findById(id));

        when(productRepository.findById(id)).thenReturn(emptyOpt);

        verify(productRepository).findById(id);
        verify(productAdapter, never()).fromEntityToDto(entity);
        verify(productAdapter, never()).fromDtoToResponse(dto);
    }
}