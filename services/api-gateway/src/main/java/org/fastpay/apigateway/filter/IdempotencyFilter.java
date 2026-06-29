package com.fastpay.apigateway.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.util.concurrent.ConcurrentHashMap;

// Ensures idempotent requests handling
@Provider
public class IdempotencyFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final String HEADER = "Idempotency-Key";
    private static final ConcurrentHashMap<String, Integer> CACHE = new ConcurrentHashMap<>();

    @Override
    public void filter(ContainerRequestContext requestContext) {

        String key = requestContext.getHeaderString(HEADER);

        if (key != null && CACHE.containsKey(key)) {
            requestContext.abortWith(
                    jakarta.ws.rs.core.Response.status(409)
                            .entity("Duplicate request")
                            .build()
            );
        }

        if (key != null) {
            CACHE.put(key, 1);
        }
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        String key = requestContext.getHeaderString(HEADER);

        if (key != null) {
            CACHE.put(key, responseContext.getStatus());
        }
    }
}