package com.fastpay.apigateway.proxy;

import com.fastpay.apigateway.routing.RouteDefinition;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;

// Orchestrates request forwarding to downstream services
@ApplicationScoped
public class GatewayProxyService {

    private final DownstreamRequestFactory requestFactory;
    private final DownstreamResponseMapper responseMapper;
    private final ServiceRegistry serviceRegistry;

    public GatewayProxyService(
            DownstreamRequestFactory requestFactory,
            DownstreamResponseMapper responseMapper,
            ServiceRegistry serviceRegistry
    ) {
        this.requestFactory = requestFactory;
        this.responseMapper = responseMapper;
        this.serviceRegistry = serviceRegistry;
    }

    public Object forward(
            RouteDefinition route,
            String path,
            String method,
            Map<String, String> headers,
            Object body
    ) {

        String baseUrl = serviceRegistry.resolve(route.getServiceId());

        Object downstreamRequest = requestFactory.create(
                baseUrl,
                path,
                method,
                headers,
                body
        );

        Object downstreamResponse = execute(downstreamRequest);

        return responseMapper.map(downstreamResponse);
    }

    private Object execute(Object request) {
        return request;
    }
}