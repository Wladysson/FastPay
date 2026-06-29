package com.fastpay.apigateway.exception;

import com.fastpay.apigateway.model.GatewayErrorResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.Instant;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {

        GatewayErrorResponse error = new GatewayErrorResponse(
                "INTERNAL_ERROR",
                exception.getMessage(),
                Instant.now().toString()
        );

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(error)
                .build();
    }
}