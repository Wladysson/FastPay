package com.fastpay.apigateway.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.util.UUID;

// Adds distributed trace information to requests
@Provider
public class TraceFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final String TRACE_ID = "X-Trace-Id";

    @Override
    public void filter(ContainerRequestContext requestContext) {

        String traceId = requestContext.getHeaderString(TRACE_ID);

        if (traceId == null || traceId.isBlank()) {
            traceId = UUID.randomUUID().toString();
        }

        requestContext.setProperty(TRACE_ID, traceId);
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {

        Object traceId = requestContext.getProperty(TRACE_ID);

        if (traceId != null) {
            responseContext.getHeaders().putSingle(TRACE_ID, traceId.toString());
        }
    }
}