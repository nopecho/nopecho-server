package io.nopecho.auth.ports.in;

import io.nopecho.auth.models.SignMethod;

public interface LoginUseCase {
    void login(SignMethod method);
}
