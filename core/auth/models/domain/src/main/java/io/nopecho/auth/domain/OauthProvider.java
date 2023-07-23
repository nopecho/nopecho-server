package io.nopecho.auth.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class OauthProvider implements Provider {

    private final Method method;
    private final Token token;

    @Override
    public Token getToken() {
        return this.token;
    }

    @Override
    public Method getMethod() {
        return this.method;
    }
}