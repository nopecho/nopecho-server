package io.nopecho.auth.domain;

import io.nopecho.utils.SelfValidator;
import io.nopecho.utils.Throws;
import lombok.Getter;

@Getter
public class Signature implements SelfValidator {

    private final Method method;
    private final Token token;

    private Signature(Method method, Token token) {
        this.method = method;
        this.token = token;
        this.selfValidation();
    }

    public static Signature of(Method method, Token token) {
        return new Signature(method, token);
    }

    public boolean equals(Signature signature) {
        return this.method.equals(signature.getMethod())
                && this.token.equals(signature.getToken());
    }

    @Override
    public void selfValidation() {
        Throws.ifNull(this.method, "accounts login method must be not null");
        Throws.ifNull(this.token, "accounts token must be not null");
        Throws.ifNullOrBlank(this.token.getValue(), "account token value must be not null or blank");
    }
}
