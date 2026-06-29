package com.fastpay.apigateway.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;

import java.util.logging.Logger;

// Logs incoming requests
@Provider
public class RequestLoggingFilter implements ContainerRequestFilter {

    private static final Logger LOGGER = Logger.getLogger(RequestLoggingFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext requestContext) {

        String method = requestContext.getMethod();
        String path = requestContext.getUriInfo().getPath();

        LOGGER.info(() -> "Incoming request: " + method + " " + path);
    }
}