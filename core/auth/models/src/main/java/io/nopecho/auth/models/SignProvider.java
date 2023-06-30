package io.nopecho.auth.models;

public interface SignProvider {
    SignToken getToken();

    SignMethod getSignMethod();
}
