package io.nopecho.auth.domain;

public interface SignProvider {
    SignToken getToken();

    SignMethod getSignMethod();
}
