package com.fastpay.apigateway.security;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;

// Relays authentication token to downstream services
@ApplicationScoped
public class TokenRelayService {

    public Map<String, String> buildHeaders(String token) {

        Map<String, String> headers = new HashMap<>();

        if (token != null && !token.isBlank()) {
            headers.put("Authorization", "Bearer " + token);
        }

        return headers;
    }

}