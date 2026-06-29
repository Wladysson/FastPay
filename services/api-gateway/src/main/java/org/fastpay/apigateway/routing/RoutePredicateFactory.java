package com.fastpay.apigateway.routing;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;
import java.util.function.Predicate;

// Creates route predicates for routing decisions
@ApplicationScoped
public class RoutePredicateFactory {

    public Predicate<RouteDefinition> pathStartsWith(String path) {

        return route -> route.getPath() != null
                && path != null
                && path.startsWith(route.getPath());
    }

    public Predicate<RouteDefinition> serviceIdEquals(String serviceId) {

        return route -> route.getServiceId() != null
                && route.getServiceId().equalsIgnoreCase(serviceId);
    }

    public Predicate<RouteDefinition> hasMetadata(String key, String value) {

        return route -> {
            if (route.getMetadata() == null) {
                return false;
            }

            Map<String, String> metadata = route.getMetadata();

            return metadata.containsKey(key)
                    && metadata.get(key).equalsIgnoreCase(value);
        };
    }
}