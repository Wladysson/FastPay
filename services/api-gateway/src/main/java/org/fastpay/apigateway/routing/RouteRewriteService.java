package com.fastpay.apigateway.routing;

import jakarta.enterprise.context.ApplicationScoped;

// Rewrites request paths before forwarding
@ApplicationScoped
public class RouteRewriteService {

    public String rewrite(String routePath, String requestPath) {

        if (routePath == null || requestPath == null) {
            return requestPath;
        }

        if (requestPath.startsWith(routePath)) {
            return requestPath.substring(routePath.length());
        }

        return requestPath;
    }

}