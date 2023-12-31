package io.nopecho.members.domain;

import io.nopecho.domain.ValueObject;
import io.nopecho.utils.SelfValidator;
import io.nopecho.utils.Throws;

public class Email implements ValueObject<String>, SelfValidator {

    private final String email;

    private Email(String email) {
        this.email = email;
        selfValidation();
    }

    public static Email of(String value) {
        return new Email(value);
    }

    @Override
    public String getValue() {
        return this.email;
    }

    @Override
    public void selfValidation() {
        Throws.ifNullOrBlank(this.email, "email must be not null");
    }
}
