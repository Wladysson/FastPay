package com.fastpay.apigateway.domain.model;

import com.fastpay.apigateway.domain.enums.ClientChannel;
import com.fastpay.apigateway.domain.enums.PermissionType;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

// Represents the authenticated user context
public final class UserContext {

    private final UUID userId;
    private final String username;
    private final String merchantId;
    private final ClientChannel clientChannel;
    private final Set<PermissionType> permissions;

    public UserContext(
            UUID userId,
            String username,
            String merchantId,
            ClientChannel clientChannel,
            Set<PermissionType> permissions
    ) {

        this.userId = Objects.requireNonNull(
                userId,
                "userId must not be null"
        );

        this.username = validate(username, "username");

        this.merchantId = validate(
                merchantId,
                "merchantId"
        );

        this.clientChannel = Objects.requireNonNull(
                clientChannel,
                "clientChannel must not be null"
        );

        Objects.requireNonNull(
                permissions,
                "permissions must not be null"
        );

        this.permissions = Collections.unmodifiableSet(
                EnumSet.copyOf(permissions)
        );
    }

    public UUID getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public ClientChannel getClientChannel() {
        return clientChannel;
    }

    public Set<PermissionType> getPermissions() {
        return permissions;
    }

    // Checks whether the user has the required permission
    public boolean hasPermission(PermissionType permission) {

        Objects.requireNonNull(
                permission,
                "permission must not be null"
        );

        return permissions.contains(permission);
    }

    // Indicates whether the request originated from a Smart POS
    public boolean isSmartPosChannel() {
        return clientChannel == ClientChannel.SMART_POS;
    }

    // Validates string attributes
    private String validate(String value, String field) {

        Objects.requireNonNull(
                value,
                field + " must not be null"
        );

        if (value.isBlank()) {
            throw new IllegalArgumentException(
                    field + " must not be blank"
            );
        }

        return value.trim();
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof UserContext other)) {
            return false;
        }

        return userId.equals(other.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "UserContext{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", clientChannel=" + clientChannel +
                ", permissions=" + permissions +
                '}';
    }

}