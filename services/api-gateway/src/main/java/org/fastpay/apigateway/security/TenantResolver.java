package com.fastpay.apigateway.security;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Objects;

// Resolves tenant information from request context
@ApplicationScoped
public class TenantResolver {

    public String resolve(String tenantHeader, String tokenTenant) {

        if (tenantHeader != null && !tenantHeader.isBlank()) {
            return tenantHeader;
        }

        if (tokenTenant != null && !tokenTenant.isBlank()) {
            return tokenTenant;
        }

        throw new IllegalStateException("Tenant could not be resolved");
    }

    public void validate(String tenantId) {

        Objects.requireNonNull(tenantId, "tenantId must not be null");

        if (tenantId.isBlank()) {
            throw new IllegalArgumentException("tenantId must not be blank");
        }
    }
}