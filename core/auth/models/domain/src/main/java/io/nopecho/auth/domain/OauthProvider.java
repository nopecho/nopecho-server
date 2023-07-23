package io.nopecho.auth.domain;

import io.nopecho.utils.Throws;
import lombok.Getter;

@Getter
public class OauthProvider implements Provider {

    private final Method method;
    private final Token token;

    protected OauthProvider(Method method, Token token) {
        this.method = method;
        this.token = token;
        this.selfValidation();
    }

    @Override
    public Token getToken() {
        return this.token;
    }

    @Override
    public Method getMethod() {
        return this.method;
    }

    @Override
    public void selfValidation() {
        Throws.ifNull(this.method, "accounts login method must be not null");
        Throws.ifNull(this.token, "accounts token must be not null");
        Throws.ifNullOrBlank(this.token.getValue(), "account token value must be not null or blank");
    }
}