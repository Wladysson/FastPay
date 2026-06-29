package com.fastpay.apigateway.security;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;

// Builds security identity from token claims
@ApplicationScoped
public class SecurityIdentityService {

    public SecurityIdentity build(Map<String, Object> claims) {

        if (claims == null) {
            throw new IllegalArgumentException("claims must not be null");
        }

        return new SecurityIdentity(
                (String) claims.getOrDefault("sub", "unknown"),
                (String) claims.getOrDefault("tenant", "unknown"),
                (String) claims.getOrDefault("channel", "API")
        );
    }

    public static class SecurityIdentity {

        private final String userId;
        private final String tenantId;
        private final String channel;

        public SecurityIdentity(String userId, String tenantId, String channel) {
            this.userId = userId;
            this.tenantId = tenantId;
            this.channel = channel;
        }

        public String getUserId() {
            return userId;
        }

        public String getTenantId() {
            return tenantId;
        }

        public String getChannel() {
            return channel;
        }
    }
}