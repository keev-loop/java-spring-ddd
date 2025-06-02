package com.market.market.repository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import com.market.market.model.entity.ProductEntity;

import java.util.List;
import java.util.Optional;


@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final IProductRepository iProductRepository;
    
    public List<ProductEntity> findAll() {
        log.info("Fetching all products from the repository");
        return iProductRepository.findAll();
    }

    public Optional<ProductEntity> findById(Long id) {
        log.info("Fetching product with ID: {}", id);
        return iProductRepository.findById(id);
    }

}
