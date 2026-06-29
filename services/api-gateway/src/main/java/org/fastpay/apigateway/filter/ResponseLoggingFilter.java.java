package com.fastpay.apigateway.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.util.logging.Logger;

// Logs outgoing responses
@Provider
public class ResponseLoggingFilter implements ContainerResponseFilter {

    private static final Logger LOGGER = Logger.getLogger(ResponseLoggingFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {

        int status = responseContext.getStatus();
        String path = requestContext.getUriInfo().getPath();

        LOGGER.info(() -> "Outgoing response: " + status + " for " + path);
    }
}