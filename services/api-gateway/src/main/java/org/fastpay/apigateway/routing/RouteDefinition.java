package com.fastpay.apigateway.routing;

import java.util.Map;

// Defines a gateway route
public class RouteDefinition {

    private String id;
    private String path;
    private String serviceId;
    private String targetUrl;
    private Map<String, String> metadata;

    public RouteDefinition() {
    }

    public RouteDefinition(String id, String path, String serviceId, String targetUrl, Map<String, String> metadata) {
        this.id = id;
        this.path = path;
        this.serviceId = serviceId;
        this.targetUrl = targetUrl;
        this.metadata = metadata;
    }

    public String getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

}