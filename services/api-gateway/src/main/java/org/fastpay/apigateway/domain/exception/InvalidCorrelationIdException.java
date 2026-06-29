package com.fastpay.apigateway.domain.exception;

// Thrown when the correlation id is invalid
public class InvalidCorrelationIdException extends RuntimeException {

    public InvalidCorrelationIdException(String message) {
        super(message);
    }

    public InvalidCorrelationIdException(String message, Throwable cause) {
        super(message, cause);
    }

}