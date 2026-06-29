package com.fastpay.apigateway.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;

import java.util.Objects;

// Extracts tenant information from request headers
@Provider
public class TenantContextFilter implements ContainerRequestFilter {

    private static final String TENANT_HEADER = "X-Tenant-Id";

    @Override
    public void filter(ContainerRequestContext requestContext) {

        String tenantId = requestContext.getHeaderString(TENANT_HEADER);

        if (tenantId == null || tenantId.isBlank()) {
            throw new IllegalStateException("Missing tenant header");
        }

        requestContext.setProperty(TENANT_HEADER, tenantId);
    }
}