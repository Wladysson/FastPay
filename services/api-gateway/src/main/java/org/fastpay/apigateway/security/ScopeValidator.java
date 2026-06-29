package com.fastpay.apigateway.security;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Set;

// Validates user scopes against required permissions
@ApplicationScoped
public class ScopeValidator {

    public boolean hasAccess(Set<String> userScopes, String requiredScope) {

        if (requiredScope == null || requiredScope.isBlank()) {
            throw new IllegalArgumentException("requiredScope must not be null or blank");
        }

        if (userScopes == null || userScopes.isEmpty()) {
            return false;
        }

        return userScopes.contains(requiredScope);
    }

    public void validate(Set<String> userScopes, String requiredScope) {

        if (!hasAccess(userScopes, requiredScope)) {
            throw new SecurityException("Access denied for scope: " + requiredScope);
        }
    }
}