package com.fastpay.apigateway.config;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

// OpenAPI configuration
@OpenAPIDefinition(
        info = @Info(
                title = "FastPay API Gateway",
                version = "1.0.0",
                description = "API Gateway for FastPay Smart POS Platform",
                contact = @Contact(
                        name = "FastPay Team",
                        email = "dev@fastpay.com"
                ),
                license = @License(
                        name = "Proprietary"
                )
        )
)
public class OpenApiConfig extends Application {
}