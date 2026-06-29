package com.fastpay.apigateway.domain.model;

import com.fastpay.apigateway.domain.valueobject.TenantId;

import java.util.Objects;

// Represents the current tenant context
public final class TenantContext {

    private final TenantId tenantId;
    private final String tenantName;
    private final boolean active;

    public TenantContext(
            TenantId tenantId,
            String tenantName,
            boolean active
    ) {

        this.tenantId = Objects.requireNonNull(
                tenantId,
                "tenantId must not be null"
        );

        this.tenantName = validateTenantName(tenantName);
        this.active = active;
    }

    public TenantId getTenantId() {
        return tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public boolean isActive() {
        return active;
    }

    // Indicates whether the tenant can process requests
    public boolean canProcessRequests() {
        return active;
    }

    // Validates tenant name
    private String validateTenantName(String tenantName) {

        Objects.requireNonNull(
                tenantName,
                "tenantName must not be null"
        );

        if (tenantName.isBlank()) {
            throw new IllegalArgumentException("tenantName must not be blank");
        }

        return tenantName.trim();
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof TenantContext other)) {
            return false;
        }

        return tenantId.equals(other.tenantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenantId);
    }

    @Override
    public String toString() {
        return "TenantContext{" +
                "tenantId=" + tenantId +
                ", tenantName='" + tenantName + '\'' +
                ", active=" + active +
                '}';
    }

}