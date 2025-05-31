package com.market.market.validator;

import java.util.Optional;

import com.market.market.model.entity.ProductEntity;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import com.market.market.exception.NotFoundException;
import com.market.market.constants.ProductConstants;

@Slf4j
@UtilityClass
public class ProductValidator {

    public static void validateProductExists(Optional<ProductEntity> entity) {
        log.info("Validando se o produto existe");
        if (entity.isEmpty())
            throw new NotFoundException(ProductConstants.PRODUCT_NOT_FOUND);
    }

}
