package com.market.market.controller.query;

import com.market.market.service.IProductService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.market.market.model.response.ProductResponse;
import org.springframework.graphql.data.method.annotation.Argument;

@Controller
@RequiredArgsConstructor
public class ProductQueryController {
    private final IProductService productService;

    @QueryMapping
    public List<ProductResponse> getAllProducts(@Argument int count, @Argument int offset) {
        return productService.getAllProducts();
    }

}