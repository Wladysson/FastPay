package com.fastpay.apigateway.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JsonUtils() {
    }

    public static String toJson(Object object) {

        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(
                    "Failed to serialize object to JSON.",
                    e
            );
        }
    }

    public static <T> T fromJson(String json, Class<T> type) {

        try {
            return OBJECT_MAPPER.readValue(json, type);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(
                    "Failed to deserialize JSON.",
                    e
            );
        }
    }

    public static ObjectMapper objectMapper() {
        return OBJECT_MAPPER;
    }
}