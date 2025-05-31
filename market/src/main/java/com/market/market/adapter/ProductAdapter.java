package com.market.market.adapter;

import org.springframework.stereotype.Component;

import com.market.market.constants.ProductConstants;
import com.market.market.model.dto.ProductDto;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.market.market.model.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;
import com.market.market.model.response.ProductResponse;


@Slf4j
@Component
@NoArgsConstructor
public class ProductAdapter {

    public ProductEntity fromResponseToEntity(ProductResponse response) {
        log.warn("Converting ProductResponse to ProductEntity is not permitted");
        throw new UnsupportedOperationException(ProductConstants.PRODUCT_ADAPTER_NOT_PERMITTED);
    }

    public ProductResponse fromEntityToResponse(ProductEntity entity) {
        log.warn("Converting ProductEntity to ProductResponse is not permitted");
        throw new UnsupportedOperationException(ProductConstants.PRODUCT_ADAPTER_NOT_PERMITTED);
    }

    public List<ProductEntity> fromResponseToEntity(List<ProductResponse> responses) {
        log.warn("Converting ProductResponse list to ProductEntity list is not permitted");
        throw new UnsupportedOperationException(ProductConstants.PRODUCT_ADAPTER_NOT_PERMITTED);
    }

    public List<ProductResponse> fromEntityToResponse(List<ProductEntity> entities) {
        log.warn("Converting ProductEntity list to ProductResponse list is not permitted");
        throw new UnsupportedOperationException(ProductConstants.PRODUCT_ADAPTER_NOT_PERMITTED);
    }

    public List<ProductDto> fromEntityToDto(List<ProductEntity> entities) {
        log.info("Converting ProductEntity list to ProductDto list");
        if (entities.isEmpty())
            return new ArrayList<>();
        
        return entities.stream()
                .map(this::fromEntityToDto)
                .toList();
    }

    public ProductDto fromEntityToDto(ProductEntity entity) {
        log.info("Converting ProductEntity to ProductDto");
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

    public List<ProductEntity> fromDtoToEntity(List<ProductDto> dtos) {
        log.info("Converting ProductDto list to ProductEntity list");
        if (dtos.isEmpty())
            return new ArrayList<>();
        
        return dtos.stream()
                .map(this::fromDtoToEntity)
                .toList();
    }

    public ProductEntity fromDtoToEntity(ProductDto dto) {
        log.info("Converting ProductDto to ProductEntity");
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

    public List<ProductResponse> fromDtoToResponse(List<ProductDto> dtos) {
        log.info("Converting ProductDto list to ProductResponse list");
        if (dtos.isEmpty())
            return new ArrayList<>();
        
        return dtos.stream()
                .map(this::fromDtoToResponse)
                .toList();
    }

    public ProductResponse fromDtoToResponse(ProductDto dto) {
        log.info("Converting ProductDto to ProductResponse");
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
