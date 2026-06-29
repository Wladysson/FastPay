package com.fastpay.apigateway.domain.valueobject;

import java.util.Objects;
import java.util.UUID;

// Represents a distributed correlation identifier
public final class CorrelationId {

    private final UUID value;

    private CorrelationId(UUID value) {
        this.value = Objects.requireNonNull(
                value,
                "correlationId must not be null"
        );
    }

    public static CorrelationId generate() {
        return new CorrelationId(UUID.randomUUID());
    }

    public static CorrelationId from(String value) {

        Objects.requireNonNull(
                value,
                "correlationId must not be null"
        );

        return new CorrelationId(
                UUID.fromString(value.trim())
        );
    }

    public static CorrelationId from(UUID value) {
        return new CorrelationId(value);
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof CorrelationId other)) {
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