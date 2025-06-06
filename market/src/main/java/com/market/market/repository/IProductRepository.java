package com.market.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.market.model.entity.ProductEntity;


@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Long> {

}
