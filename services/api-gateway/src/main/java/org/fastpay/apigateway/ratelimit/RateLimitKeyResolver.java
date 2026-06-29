package com.fastpay.apigateway.ratelimit;

import com.fastpay.apigateway.model.UserContext;
import com.fastpay.apigateway.model.TenantContext;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;

@ApplicationScoped
public class RateLimitKeyResolver {

    @Inject
    HttpServletRequest request;

    public String resolve() {

        String tenantId = (String) request.getAttribute(TenantContext.KEY);
        String userId = (String) request.getAttribute(UserContext.KEY);
        String deviceId = request.getHeader("X-Device-Id");
        String ip = request.getRemoteAddr();

        if (tenantId != null && deviceId != null) {
            return tenantId + ":" + deviceId;
        }

        if (tenantId != null && userId != null) {
            return tenantId + ":" + userId;
        }

        return "ip:" + ip;
    }
}