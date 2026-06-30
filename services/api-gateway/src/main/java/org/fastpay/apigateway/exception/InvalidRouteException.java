package com.fastpay.apigateway.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class InvalidRouteException extends WebApplicationException {

    public InvalidRouteException(String message) {
        super(message, Response.Status.NOT_FOUND);
    }
}