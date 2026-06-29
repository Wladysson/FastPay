package com.fastpay.apigateway.config;

import io.smallrye.config.ConfigMapping;

import java.time.Duration;
import java.util.Map;

// Gateway configuration
@ConfigMapping(prefix = "fastpay.gateway")
public interface GatewayConfig {

    String name();

    String version();

    Duration connectTimeout();

    Duration readTimeout();

    Duration writeTimeout();

    Duration responseTimeout();

    Retry retry();

    Headers headers();

    Map<String, Service> services();

    interface Retry {

        int maxAttempts();

        Duration delay();

    }

    interface Headers {

        String correlationId();

        String tenantId();

        String authorization();

        String idempotencyKey();

        String clientChannel();

        String traceId();

    }

    interface Service {

        String baseUrl();

        boolean enabled();

    }

}