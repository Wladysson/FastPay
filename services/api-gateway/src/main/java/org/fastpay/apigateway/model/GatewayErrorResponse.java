package com.fastpay.apigateway.model;

import java.time.Instant;

public class GatewayErrorResponse {

    private String code;
    private String message;
    private String timestamp;
    private String correlationId;
    private String path;

    public GatewayErrorResponse() {
        this.timestamp = Instant.now().toString();
    }

    public GatewayErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = Instant.now().toString();
    }

    public GatewayErrorResponse(
            String code,
            String message,
            String timestamp
    ) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}