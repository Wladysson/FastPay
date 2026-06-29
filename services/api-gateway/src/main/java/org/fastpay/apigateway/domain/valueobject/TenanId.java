package com.fastpay.apigateway.domain.valueobject;

import java.util.Objects;
import java.util.UUID;

// Represents a tenant identifier
public final class TenantId {

    private final UUID value;

    private TenantId(UUID value) {
        this.value = Objects.requireNonNull(
                value,
                "tenantId must not be null"
        );
    }

    public static TenantId generate() {
        return new TenantId(UUID.randomUUID());
    }

    public static TenantId from(UUID value) {
        return new TenantId(value);
    }

    public static TenantId from(String value) {

        Objects.requireNonNull(
                value,
                "tenantId must not be null"
        );

        return new TenantId(
                UUID.fromString(value.trim())
        );
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof TenantId other)) {
            return false;
        }

        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

}