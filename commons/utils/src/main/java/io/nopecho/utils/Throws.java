package io.nopecho.utils;

import java.util.Objects;

public class Throws {

    public static void ifNull(Object o, String massage) {
        if (Objects.isNull(o)) {
            throw new RuntimeException(massage);
        }
    }

    public static void ifBlank(String string, String massage) {
        if (string.isBlank()) {
            throw new RuntimeException(massage);
        }
    }

    public static void ifNullOrBlank(String string, String massage) {
        if (Objects.isNull(string) || string.isBlank()) {
            throw new RuntimeException(massage);
        }
    }
}
