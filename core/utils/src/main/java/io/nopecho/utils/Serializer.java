package io.nopecho.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Map;

public class Serializer {

    private static volatile ObjectMapper mapper;

    private static ObjectMapper get() {
        ObjectMapper result = mapper;
        if (result == null) {
            synchronized (Serializer.class) {
                result = mapper;
                if (result == null) {
                    mapper = result = new ObjectMapper()
                            .registerModule(new JavaTimeModule())
                            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                }
            }
        }
        return result;
    }

    public static String serialize(Object o) {
        try {
            return get().writeValueAsString(o);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static <T> T deserialize(String target, Class<T> clazz) {
        try {
            return get().readValue(target, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static Map<String, Object> convertMap(Object o) {
        String serialize = serialize(o);
        try {
            return get().convertValue(o, Map.class);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
