package com.fastpay.apigateway.routing;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Resolves routes for incoming requests
@ApplicationScoped
public class RouteLocatorService {

    private final List<RouteDefinition> routes = new ArrayList<>();

    public RouteLocatorService() {
        // default routes can be loaded from config later
    }

    public Optional<RouteDefinition> findRoute(String path) {

        if (path == null || path.isBlank()) {
            return Optional.empty();
        }

        return routes.stream()
                .filter(route -> match(route.getPath(), path))
                .findFirst();
    }

    public void register(RouteDefinition routeDefinition) {

        if (routeDefinition == null) {
            throw new IllegalArgumentException("routeDefinition must not be null");
        }

        routes.add(routeDefinition);
    }

    private boolean match(String routePath, String requestPath) {
        return requestPath.startsWith(routePath);
    }
}