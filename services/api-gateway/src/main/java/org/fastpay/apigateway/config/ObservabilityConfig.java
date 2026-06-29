package com.fastpay.apigateway.config;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

// Observability configuration
@ApplicationScoped
public class ObservabilityConfig {

    @Produces
    public Tracer tracer() {
        return GlobalOpenTelemetry.getTracer("fastpay-api-gateway");
    }

}