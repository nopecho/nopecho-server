package io.nopecho.auth.domain;

import io.nopecho.domain.ValueObject;
import io.nopecho.utils.SelfValidator;
import io.nopecho.utils.Throws;
import lombok.Value;

@Value(staticConstructor = "of")
public class SignToken implements ValueObject<String>, SelfValidator {

    String token;

    private SignToken(String token) {
        this.token = token;
        selfValidation();
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
