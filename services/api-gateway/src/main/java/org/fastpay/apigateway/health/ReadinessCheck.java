package com.fastpay.apigateway.health;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReadinessCheck {

    public boolean isReady() {

        try {
            // Simula validações reais do gateway

            checkMemory();
            checkInternalServices();

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    private void checkMemory() {
        long freeMemory = Runtime.getRuntime().freeMemory();

        if (freeMemory < 50_000_000) { // 50MB mínimo
            throw new IllegalStateException("Low memory");
        }
    }

    private void checkInternalServices() {
        // futuro: Redis, auth-service, tenant-service
        // por enquanto só simulação
    }
}