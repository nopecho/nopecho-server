package io.nopecho.auth.domain;

import io.nopecho.utils.SelfValidator;

public interface Provider extends SelfValidator {
    Token getToken();

    Method getMethod();
}
