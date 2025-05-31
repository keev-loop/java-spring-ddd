package com.market.market.service;

import com.market.market.validator.ProductValidator;

import java.util.List;
import com.market.market.model.response.ProductResponse;


import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.market.market.adapter.ProductAdapter;
import com.market.market.repository.ProductRepository;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final ProductRepository productRepository;
    private final ProductAdapter productAdapter;

    @Override
    public List<ProductResponse> getAllProducts() {
        var entities = productRepository.findAll();
        var dtos = productAdapter.fromEntityToDto(entities);
        return productAdapter.fromDtoToResponse(dtos);
    }

    @Override
    public ProductResponse getProductById(Long id) {
        var entity = productRepository.findById(id);
        ProductValidator.validateProductExists(entity);
        var dto = productAdapter.fromEntityToDto(entity.get());
        return productAdapter.fromDtoToResponse(dto);
    }
}
