package com.ecommerce.commons.exception;

public class UnexpectedFailureException extends RuntimeException {
    public UnexpectedFailureException(String message) {
        super(message);
    }
}
