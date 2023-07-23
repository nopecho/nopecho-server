package io.nopecho.auth.domain;

public interface Provider {
    Token getToken();

    Method getMethod();
}
