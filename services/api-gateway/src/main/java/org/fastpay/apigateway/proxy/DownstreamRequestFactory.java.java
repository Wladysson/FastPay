package com.fastpay.apigateway.proxy;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;

// Builds downstream HTTP request objects
@ApplicationScoped
public class DownstreamRequestFactory {

    public Object create(
            String baseUrl,
            String path,
            String method,
            Map<String, String> headers,
            Object body
    ) {

        return new DownstreamRequest(
                baseUrl,
                path,
                method,
                headers,
                body
        );
    }

    public static class DownstreamRequest {

        private final String baseUrl;
        private final String path;
        private final String method;
        private final Map<String, String> headers;
        private final Object body;

        public DownstreamRequest(
                String baseUrl,
                String path,
                String method,
                Map<String, String> headers,
                Object body
        ) {
            this.baseUrl = baseUrl;
            this.path = path;
            this.method = method;
            this.headers = headers;
            this.body = body;
        }

        public String getBaseUrl() {
            return baseUrl;
        }

        public String getPath() {
            return path;
        }

        public String getMethod() {
            return method;
        }

        public Map<String, String> getHeaders() {
            return headers;
        }

        public Object getBody() {
            return body;
        }
    }
}