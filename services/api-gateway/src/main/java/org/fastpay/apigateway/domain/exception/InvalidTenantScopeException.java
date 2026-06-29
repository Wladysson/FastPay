package com.fastpay.apigateway.domain.exception;

// Thrown when the tenant scope is invalid
public class InvalidTenantScopeException extends RuntimeException {

    public InvalidTenantScopeException(String message) {
        super(message);
    }

    public InvalidTenantScopeException(String message, Throwable cause) {
        super(message, cause);
    }

}