package com.fastpay.apigateway.config;

import io.quarkus.security.Authenticated;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

// Security configuration
@ApplicationPath("/api")
@Authenticated
public class SecurityConfig extends Application {
}