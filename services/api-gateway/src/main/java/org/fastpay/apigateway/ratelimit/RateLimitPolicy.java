package com.fastpay.apigateway.ratelimit;

import java.time.Duration;

public class RateLimitPolicy {

    private final String routeId;
    private final long requests;
    private final Duration window;

    private final boolean enabled;

    public RateLimitPolicy(String routeId, long requests, Duration window, boolean enabled) {
        this.routeId = routeId;
        this.requests = requests;
        this.window = window;
        this.enabled = enabled;
    }

    public String getRouteId() {
        return routeId;
    }

    public long getRequests() {
        return requests;
    }

    public Duration getWindow() {
        return window;
    }

    public boolean isEnabled() {
        return enabled;
    }
}