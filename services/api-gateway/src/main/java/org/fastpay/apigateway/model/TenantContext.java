package com.fastpay.apigateway.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TenantContext {

    public static final String KEY = "TENANT_CONTEXT";

    private String tenantId;
    private String tenantName;
    private String environment;
    private Map<String, String> attributes = new HashMap<>();

    public TenantContext() {
    }

    public TenantContext(
            String tenantId,
            String tenantName,
            String environment,
            Map<String, String> attributes
    ) {
        this.tenantId = tenantId;
        this.tenantName = tenantName;
        this.environment = environment;
        this.attributes = attributes != null
                ? new HashMap<>(attributes)
                : new HashMap<>();
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getEnvironment() {
        return environment;
    }

    public Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(attributes);
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes != null
                ? new HashMap<>(attributes)
                : new HashMap<>();
    }

    public String getAttribute(String key) {
        return attributes.get(key);
    }
}