package com.fastpay.apigateway.domain.model;

import com.fastpay.apigateway.domain.valueobject.CorrelationId;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public final class CorrelationContext {

    private final CorrelationId correlationId;

    private final UUID requestId;

    private final Instant requestTimestamp;

    public CorrelationContext(
            CorrelationId correlationId,
            UUID requestId,
            Instant requestTimestamp
    ) {

        this.correlationId = Objects.requireNonNull(
                correlationId,
                "correlationId must not be null"
        );

        this.requestId = Objects.requireNonNull(
                requestId,
                "requestId must not be null"
        );

        this.requestTimestamp = Objects.requireNonNull(
                requestTimestamp,
                "requestTimestamp must not be null"
        );
    }

    public static CorrelationContext create(CorrelationId correlationId) {

        return new CorrelationContext(
                correlationId,
                UUID.randomUUID(),
                Instant.now()
        );

    }

    public CorrelationId getCorrelationId() {
        return correlationId;
    }

    public UUID getRequestId() {
        return requestId;
    }

    public Instant getRequestTimestamp() {
        return requestTimestamp;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof CorrelationContext other)) {
            return false;
        }

        return correlationId.equals(other.correlationId)
                && requestId.equals(other.requestId);

    }

    @Override
    public int hashCode() {
        return Objects.hash(
                correlationId,
                requestId
        );
    }

    @Override
    public String toString() {

        return "CorrelationContext{" +
                "correlationId=" + correlationId +
                ", requestId=" + requestId +
                ", requestTimestamp=" + requestTimestamp +
                '}';

    }

}