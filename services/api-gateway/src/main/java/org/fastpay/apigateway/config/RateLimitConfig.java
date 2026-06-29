package com.fastpay.apigateway.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;

// Rate limit configuration
@ApplicationScoped
public class RateLimitConfig {

    @Produces
    public RateLimitProperties rateLimitProperties() {
        return new RateLimitProperties();
    }

    public static class RateLimitProperties {

        private int requestsPerMinute = 1000;
        private int burstCapacity = 200;

        public int getRequestsPerMinute() {
            return requestsPerMinute;
        }

        public void setRequestsPerMinute(int requestsPerMinute) {
            this.requestsPerMinute = requestsPerMinute;
        }

        public int getBurstCapacity() {
            return burstCapacity;
        }

        public void setBurstCapacity(int burstCapacity) {
            this.burstCapacity = burstCapacity;
        }
    }
}