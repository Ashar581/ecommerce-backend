package com.ecommerce.commons.exception;

public class ActionRestrictedException extends RuntimeException {
    public ActionRestrictedException(String message) {
        super(message);
    }
}
