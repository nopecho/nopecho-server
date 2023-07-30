package io.nopecho.auth.domain;

import io.nopecho.domain.ValueObject;
import io.nopecho.utils.SelfValidator;
import io.nopecho.utils.Throws;
import lombok.Value;

@Value(staticConstructor = "of")
public class Token implements ValueObject<String>, SelfValidator {

    String token;

    private Token(String token) {
        this.token = token;
        selfValidation();
    }

    public boolean equals(Token token) {
        return this.token.equals(token.getToken());
    }

    @Override
    public String getValue() {
        return this.token;
    }

    @Override
    public void selfValidation() {
        Throws.ifNullOrBlank(this.token, "sign token must be not null");
    }
}
