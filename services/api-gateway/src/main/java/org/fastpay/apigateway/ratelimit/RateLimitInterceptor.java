package com.fastpay.apigateway.ratelimit;

import com.fastpay.apigateway.exception.RateLimitExceededException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;

import java.time.Duration;

@Provider
@ApplicationScoped
public class RateLimitInterceptor implements ContainerRequestFilter {

    @Inject
    RateLimitService rateLimitService;

    @Inject
    RateLimitKeyResolver keyResolver;

    @Override
    public void filter(ContainerRequestContext requestContext) {

        // regra simples inicial (vai vir do YAML depois)
        RateLimitPolicy policy = new RateLimitPolicy(
                requestContext.getUriInfo().getPath(),
                100, // 100 req
                Duration.ofMinutes(1),
                true
        );

        if (!policy.isEnabled()) {
            return;
        }

        String key = keyResolver.resolve();

        boolean allowed = rateLimitService.allow(key, policy);

        if (!allowed) {
            throw new RateLimitExceededException(
                    "Rate limit exceeded for key: " + key
            );
        }
    }
}