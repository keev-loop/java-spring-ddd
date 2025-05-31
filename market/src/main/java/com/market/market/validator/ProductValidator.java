package com.market.market.validator;

import java.util.Optional;

import com.market.market.model.entity.ProductEntity;
import lombok.experimental.UtilityClass;
import com.market.market.exception.NotFoundException;
import com.market.market.constants.ProductConstants;

@UtilityClass
public class ProductValidator {

    public static void validateProductExists(Optional<ProductEntity> entity) {
        if (entity.isEmpty())
            throw new NotFoundException(ProductConstants.PRODUCT_NOT_FOUND);
    }

}
