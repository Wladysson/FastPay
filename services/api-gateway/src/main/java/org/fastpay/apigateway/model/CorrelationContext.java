package com.fastpay.apigateway.model;

import java.time.Instant;

public class CorrelationContext {

    public static final String KEY = "CORRELATION_CONTEXT";

    private String correlationId;
    private Instant createdAt;

    public CorrelationContext() {
        this.createdAt = Instant.now();
    }

    public CorrelationContext(String correlationId) {
        this.correlationId = correlationId;
        this.createdAt = Instant.now();
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}