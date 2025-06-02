package com.market.market.mocks;

import com.market.market.model.entity.ProductEntity;
import com.market.market.model.response.ProductResponse;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ModelsMock {
    
    public static ProductEntity getProductEntity() {
        return ProductEntity.builder()
                .id(1L)
                .name("Product 1")
                .description("Description of Product 1")
                .price(100.0)
                .category("Category 1")
                .build();
    }

    public static ProductResponse getProductResponse() {
        return ProductResponse.builder()
                .id(1L)
                .name("Product 1")
                .description("Description of Product 1")
                .price(100.0)
                .category("Category 1")
                .build();
    }

}
