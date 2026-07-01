package com.fastpay.apigateway.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UserContext {

    public static final String KEY = "USER_CONTEXT";

    private String userId;
    private String username;
    private String merchantId;
    private Set<String> scopes = new HashSet<>();

    public UserContext() {
    }

    public UserContext(
            String userId,
            String username,
            String merchantId,
            Set<String> scopes
    ) {
        this.userId = userId;
        this.username = username;
        this.merchantId = merchantId;
        this.scopes = scopes != null ? new HashSet<>(scopes) : new HashSet<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public Set<String> getScopes() {
        return Collections.unmodifiableSet(scopes);
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public void setScopes(Set<String> scopes) {
        this.scopes = scopes != null ? new HashSet<>(scopes) : new HashSet<>();
    }

    public boolean hasScope(String scope) {
        return scopes.contains(scope);
    }
}