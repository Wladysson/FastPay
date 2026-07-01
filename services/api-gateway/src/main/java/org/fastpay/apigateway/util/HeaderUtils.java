package com.fastpay.apigateway.util;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MultivaluedMap;

public final class HeaderUtils {

    public static final String CORRELATION_ID = "X-Correlation-Id";
    public static final String TENANT_ID = "X-Tenant-Id";
    public static final String DEVICE_ID = "X-Device-Id";
    public static final String IDEMPOTENCY_KEY = "Idempotency-Key";
    public static final String MERCHANT_ID = "X-Merchant-Id";

    private HeaderUtils() {
    }

    public static String getHeader(HttpHeaders headers, String name) {
        return headers.getHeaderString(name);
    }

    public static void putHeader(
            MultivaluedMap<String, Object> headers,
            String name,
            String value
    ) {
        if (value != null && !value.isBlank()) {
            headers.putSingle(name, value);
        }
    }

    public static boolean hasHeader(HttpHeaders headers, String name) {
        return headers.getHeaderString(name) != null;
    }

    public static String getAuthorization(HttpHeaders headers) {
        return headers.getHeaderString(HttpHeaders.AUTHORIZATION);
    }
}