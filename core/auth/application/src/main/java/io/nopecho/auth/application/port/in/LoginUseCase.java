package io.nopecho.auth.application.port.in;

import io.nopecho.auth.domain.SignMethod;

public interface LoginUseCase {
    void login(SignMethod method);
}
