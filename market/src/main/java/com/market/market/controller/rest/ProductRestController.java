package com.market.market.controller.rest;

import org.springframework.web.bind.annotation.RestController;
import com.market.market.service.IProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import com.market.market.model.response.ProductResponse;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductRestController {
    private final IProductService productService;


    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
         return ResponseEntity
                     .status(HttpStatus.OK)
                     .body(productService.getAllProducts());
    }
}