package com.fastpay.apigateway.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class ForbiddenException extends WebApplicationException {

    public ForbiddenException(String message) {
        super(message, Response.Status.FORBIDDEN);
    }
}