package io.nopecho.auth.application.usecase;


import io.nopecho.auth.domain.Method;

public interface LoginUseCase {
    void login(Method method);
}
