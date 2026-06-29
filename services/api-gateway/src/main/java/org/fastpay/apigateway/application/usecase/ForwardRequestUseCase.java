package com.fastpay.apigateway.application.usecase;

import com.fastpay.apigateway.application.service.RouteResolutionService;
import com.fastpay.apigateway.domain.model.GatewayRoute;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Objects;

// Resolves the target route for an incoming request
@ApplicationScoped
public class ForwardRequestUseCase {

    private final RouteResolutionService routeResolutionService;

    public ForwardRequestUseCase(
            RouteResolutionService routeResolutionService
    ) {
        this.routeResolutionService = Objects.requireNonNull(
                routeResolutionService,
                "routeResolutionService must not be null"
        );
    }

    public GatewayRoute execute(String requestPath) {

        Objects.requireNonNull(
                requestPath,
                "requestPath must not be null"
        );

        if (requestPath.isBlank()) {
            throw new IllegalArgumentException(
                    "requestPath must not be blank"
            );
        }

        return routeResolutionService.resolve(requestPath);
    }

}