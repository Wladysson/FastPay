package com.fastpay.apigateway.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class UnauthorizedException extends WebApplicationException {

    public UnauthorizedException(String message) {
        super(message, Response.Status.UNAUTHORIZED);
    }
}