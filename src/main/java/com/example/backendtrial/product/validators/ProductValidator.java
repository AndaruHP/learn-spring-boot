package com.example.backendtrial.product.validators;

import com.example.backendtrial.product.exceptions.ErrorMessages;
import com.example.backendtrial.product.exceptions.ProductNotValidException;
import com.example.backendtrial.product.model.Product;
import com.mysql.cj.util.StringUtils;

public class ProductValidator {
    private ProductValidator() {

    }

    public static void execute (Product product) {
        if (StringUtils.isEmptyOrWhitespaceOnly(product.getName())) {
            throw new ProductNotValidException(ErrorMessages.NAME_REQUIRED.getMessage());
        }

        if (product.getDescription().length() < 20) {
            throw new ProductNotValidException(ErrorMessages.DESCRIPTION_LENGTH.getMessage());
        }

        if (product.getPrice() < 0.00 || product.getPrice() == null) {
            throw new ProductNotValidException(ErrorMessages.PRICE_CANNOT_BE_NEGATIVE.getMessage());
        }
    }
}
