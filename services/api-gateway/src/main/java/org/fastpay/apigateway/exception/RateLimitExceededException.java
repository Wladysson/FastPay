package com.fastpay.apigateway.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class RateLimitExceededException extends WebApplicationException {

    public RateLimitExceededException(String message) {
        super(message, Response.Status.TOO_MANY_REQUESTS);
    }
}