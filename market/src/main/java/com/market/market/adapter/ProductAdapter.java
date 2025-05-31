package com.market.market.adapter;

import org.springframework.stereotype.Component;

import com.market.market.constants.ProductConstants;
import com.market.market.dto.ProductDto;
import lombok.NoArgsConstructor;
import com.market.market.entity.ProductEntity;
import java.util.List;
import java.util.stream.Collectors;
import com.market.market.response.ProductResponse;


@Component
@NoArgsConstructor
public class ProductAdapter {

    public ProductEntity toEntity(ProductResponse response) {
        throw new UnsupportedOperationException(ProductConstants.PRODUCT_ADAPTER_NOT_PERMITTED);
    }

    public ProductResponse toResponse(ProductEntity entity) {
        throw new UnsupportedOperationException(ProductConstants.PRODUCT_ADAPTER_NOT_PERMITTED);
    }

    public List<ProductEntity> toEntity(List<ProductResponse> responses) {
        throw new UnsupportedOperationException(ProductConstants.PRODUCT_ADAPTER_NOT_PERMITTED);
    }

    public List<ProductResponse> toResponse(List<ProductEntity> entities) {
        throw new UnsupportedOperationException(ProductConstants.PRODUCT_ADAPTER_NOT_PERMITTED);
    }

    public List<ProductDto> toDto(List<ProductEntity> entities) {
        if (entities.isEmpty())
            return entities;
        
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public ProductDto toDto(ProductEntity entity) {
        if (entity == null) 
            return null;

        ProductDto dto = new ProductDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setCategory(entity.getCategory());
        
        return dto;
    }

    public List<ProductEntity> toEntity(List<ProductDto> dtos) {
        if (dtos.isEmpty())
            return dtos;
        
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public ProductEntity toEntity(ProductDto dto) {
        if (dto == null)
            return null;

        ProductEntity entity = new ProductEntity();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setCategory(dto.getCategory());
        
        return entity;
    }

    public List<ProductResponse> toResponse(List<ProductDto> dtos) {
        if (dtos.isEmpty())
            return dtos;
        
        return dtos.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse toResponse(ProductDto dto) {
        if (dto == null)
            return null;

        ProductResponse response = new ProductResponse();

        response.setId(dto.getId());
        response.setName(dto.getName());
        response.setDescription(dto.getDescription());
        response.setPrice(dto.getPrice());
        response.setCategory(dto.getCategory());
        
        return response;
    }
}
