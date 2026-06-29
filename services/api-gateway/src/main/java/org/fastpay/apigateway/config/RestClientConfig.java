package com.fastpay.apigateway.config;

import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;

import java.net.URI;
import java.time.Duration;

// REST client configuration
public class RestClientConfig {

    public static <T> T buildClient(Class<T> clientClass, String baseUrl) {

        return QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(baseUrl))
                .connectTimeout(Duration.ofSeconds(3))
                .readTimeout(Duration.ofSeconds(10))
                .build(clientClass);
    }

}