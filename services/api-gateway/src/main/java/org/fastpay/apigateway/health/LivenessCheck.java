package com.fastpay.apigateway.health;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LivenessCheck {

    public boolean isAlive() {
        // aqui só valida se JVM está funcionando
        return true;
    }
}