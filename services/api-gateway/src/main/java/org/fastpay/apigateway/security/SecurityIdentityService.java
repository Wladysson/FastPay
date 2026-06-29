package com.fastpay.apigateway.domain.enums;

// Defines gateway permissions
public enum PermissionType {

    PAYMENT_CREATE,
    PAYMENT_CAPTURE,
    PAYMENT_CANCEL,
    PAYMENT_REFUND,

    MERCHANT_READ,
    MERCHANT_CREATE,
    MERCHANT_UPDATE,

    TRANSACTION_READ,

    SETTLEMENT_READ,
    SETTLEMENT_PROCESS,

    NOTIFICATION_SEND,

    ADMIN

}