package com.fastpay.apigateway.domain.model;

import com.fastpay.apigateway.domain.enums.RouteType;

import java.time.Duration;
import java.util.Objects;

public final class GatewayRoute {

    private final String serviceName;
    private final String basePath;
    private final RouteType routeType;
    private final Duration timeout;
    private final boolean authenticationRequired;
    private final boolean idempotencyRequired;

    public GatewayRoute(
            String serviceName,
            String basePath,
            RouteType routeType,
            Duration timeout,
            boolean authenticationRequired,
            boolean idempotencyRequired
    ) {

        this.serviceName = validate(serviceName, "serviceName");
        this.basePath = validate(basePath, "basePath");
        this.routeType = Objects.requireNonNull(routeType, "routeType must not be null");
        this.timeout = Objects.requireNonNull(timeout, "timeout must not be null");

        if (timeout.isNegative() || timeout.isZero()) {
            throw new IllegalArgumentException("timeout must be greater than zero");
        }

        this.authenticationRequired = authenticationRequired;
        this.idempotencyRequired = idempotencyRequired;
    }

    // Indicates whether the route requires authentication
    public boolean requiresAuthentication() {
        return authenticationRequired;
    }

    // Indicates whether the route requires idempotency
    public boolean requiresIdempotency() {
        return idempotencyRequired;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getBasePath() {
        return basePath;
    }

    public RouteType getRouteType() {
        return routeType;
    }

    public Duration getTimeout() {
        return timeout;
    }

    public boolean isAuthenticationRequired() {
        return authenticationRequired;
    }

    public boolean isIdempotencyRequired() {
        return idempotencyRequired;
    }

    private String validate(String value, String field) {

        Objects.requireNonNull(value, field + " must not be null");

        if (value.isBlank()) {
            throw new IllegalArgumentException(field + " must not be blank");
        }

        return value;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof GatewayRoute other)) {
            return false;
        }

        return serviceName.equals(other.serviceName)
                && basePath.equals(other.basePath)
                && routeType == other.routeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                serviceName,
                basePath,
                routeType
        );
    }

    @Override
    public String toString() {
        return "GatewayRoute{" +
                "serviceName='" + serviceName + '\'' +
                ", basePath='" + basePath + '\'' +
                ", routeType=" + routeType +
                ", timeout=" + timeout +
                ", authenticationRequired=" + authenticationRequired +
                ", idempotencyRequired=" + idempotencyRequired +
                '}';
    }

}