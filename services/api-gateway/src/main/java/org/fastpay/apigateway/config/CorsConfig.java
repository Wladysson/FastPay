package com.fastpay.apigateway.config;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.Provider;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;
import com.fastpay.apigateway.exception.GlobalExceptionHandler;

// CORS configuration
@Provider
public class CorsConfig {

    @ServerExceptionMapper
    @Produces(MediaType.APPLICATION_JSON)
    public GlobalExceptionHandler handleException(Exception exception) {
        return GlobalExceptionHandler.from(exception);
    }

}