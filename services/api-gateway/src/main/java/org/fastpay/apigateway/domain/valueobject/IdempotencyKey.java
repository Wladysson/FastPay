package com.fastpay.apigateway.domain.valueobject;

import java.util.Objects;
import java.util.UUID;

// Represents an idempotency key
public final class IdempotencyKey {

    private static final int MAX_LENGTH = 255;

    private final String value;

    private IdempotencyKey(String value) {
        this.value = validate(value);
    }

    public static IdempotencyKey generate() {
        return new IdempotencyKey(UUID.randomUUID().toString());
    }

    public static IdempotencyKey from(String value) {
        return new IdempotencyKey(value);
    }

    public String getValue() {
        return value;
    }

    // Validates the idempotency key
    private String validate(String value) {

        Objects.requireNonNull(
                value,
                "idempotencyKey must not be null"
        );

        String normalized = value.trim();

        if (normalized.isBlank()) {
            throw new IllegalArgumentException(
                    "idempotencyKey must not be blank"
            );
        }

        if (normalized.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    "idempotencyKey exceeds the maximum length of " + MAX_LENGTH
            );
        }

        return normalized;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof IdempotencyKey other)) {
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
        return value;
    }

}