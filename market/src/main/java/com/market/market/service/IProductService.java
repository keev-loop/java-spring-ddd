package com.market.market.service;

import java.util.List;

import com.market.market.model.response.ProductResponse;


public interface IProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(Long id);
}
