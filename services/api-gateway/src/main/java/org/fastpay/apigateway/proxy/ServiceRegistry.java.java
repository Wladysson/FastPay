package com.fastpay.apigateway.proxy;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Resolves downstream service base URLs
@ApplicationScoped
public class ServiceRegistry {

    private final Map<String, String> services = new ConcurrentHashMap<>();

    public ServiceRegistry() {
        // default registry entries (can be loaded from config later)
        services.put("payment-service", "http://payment-service:8080");
        services.put("merchant-service", "http://merchant-service:8080");
        services.put("transaction-service", "http://transaction-service:8080");
        services.put("settlement-service", "http://settlement-service:8080");
        services.put("notification-service", "http://notification-service:8080");
    }

    public String resolve(String serviceId) {

        if (serviceId == null || serviceId.isBlank()) {
            throw new IllegalArgumentException("serviceId must not be null or blank");
        }

        String url = services.get(serviceId);

        if (url == null) {
            throw new IllegalStateException("No service registered for: " + serviceId);
        }

        return url;
    }

    public void register(String serviceId, String baseUrl) {

        if (serviceId == null || serviceId.isBlank()) {
            throw new IllegalArgumentException("serviceId must not be null or blank");
        }

        if (baseUrl == null || baseUrl.isBlank()) {
            throw new IllegalArgumentException("baseUrl must not be null or blank");
        }

        services.put(serviceId, baseUrl);
    }
}