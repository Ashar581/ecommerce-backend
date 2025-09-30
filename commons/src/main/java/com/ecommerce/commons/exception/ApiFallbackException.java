package com.ecommerce.commons.exception;

public class ApiFallbackException extends RuntimeException {
    public ApiFallbackException(String message) {
        super(message);
    }
}
