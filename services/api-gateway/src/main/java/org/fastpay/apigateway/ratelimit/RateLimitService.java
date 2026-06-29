package com.fastpay.apigateway.ratelimit;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class RateLimitService {

    private static class Counter {
        long count;
        long windowStart;
    }

    private final Map<String, Counter> store = new ConcurrentHashMap<>();

    public boolean allow(String key, RateLimitPolicy policy) {

        long now = Instant.now().toEpochMilli();
        long windowMs = policy.getWindow().toMillis();

        Counter counter = store.computeIfAbsent(key, k -> new Counter());

        synchronized (counter) {

            if (now - counter.windowStart > windowMs) {
                counter.windowStart = now;
                counter.count = 0;
            }

            if (counter.count >= policy.getRequests()) {
                return false;
            }

            counter.count++;
            return true;
        }
    }
}