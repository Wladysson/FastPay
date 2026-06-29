package com.fastpay.apigateway.proxy;

import jakarta.enterprise.context.ApplicationScoped;

// Maps downstream responses to gateway responses
@ApplicationScoped
public class DownstreamResponseMapper {

    public Object map(Object downstreamResponse) {

        if (downstreamResponse == null) {
            return null;
        }

        return new GatewayResponse(downstreamResponse);
    }

    public static class GatewayResponse {

        private final Object data;

        public GatewayResponse(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }
}