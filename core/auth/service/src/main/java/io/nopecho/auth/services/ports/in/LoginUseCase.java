package io.nopecho.auth.services.ports.in;


import io.nopecho.auth.domain.Method;

public interface LoginUseCase {
    void login(Method method);
}
