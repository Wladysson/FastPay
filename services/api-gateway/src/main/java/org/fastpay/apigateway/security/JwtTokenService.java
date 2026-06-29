package com.fastpay.apigateway.security;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;

// Handles JWT token operations
@ApplicationScoped
public class JwtTokenService {

    public String extractToken(String authorizationHeader) {

        if (authorizationHeader == null || authorizationHeader.isBlank()) {
            return null;
        }

        if (!authorizationHeader.startsWith("Bearer ")) {
            return null;
        }

        return authorizationHeader.substring(7);
    }

    public Map<String, Object> decode(String token) {

        if (token == null || token.isBlank()) {
            throw new IllegalArgumentException("token must not be null or blank");
        }
        // placeholder decode (real implementation will verify signature)
        return Map.of(
                "token", token,
                "valid", true
        );
    }
}