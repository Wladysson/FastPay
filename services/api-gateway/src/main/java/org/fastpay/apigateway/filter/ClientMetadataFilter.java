package com.fastpay.apigateway.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;

// Extracts client metadata from headers
@Provider
public class ClientMetadataFilter implements ContainerRequestFilter {

    private static final String CLIENT_ID_HEADER = "X-Client-Id";
    private static final String CHANNEL_HEADER = "X-Client-Channel";

    @Override
    public void filter(ContainerRequestContext requestContext) {

        String clientId = requestContext.getHeaderString(CLIENT_ID_HEADER);
        String channel = requestContext.getHeaderString(CHANNEL_HEADER);

        if (clientId != null) {
            requestContext.setProperty(CLIENT_ID_HEADER, clientId);
        }

        if (channel != null) {
            requestContext.setProperty(CHANNEL_HEADER, channel);
        }
    }
}