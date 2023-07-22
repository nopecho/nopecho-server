package io.nopecho.auth.services.ports.in;


import io.nopecho.auth.domain.SignMethod;

public interface LoginUseCase {
    void login(SignMethod method);
}
