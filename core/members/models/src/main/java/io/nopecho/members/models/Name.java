package io.nopecho.members.models;

import io.nopecho.domain.ValueObject;
import io.nopecho.utils.SelfValidator;
import io.nopecho.utils.Throws;

public class Name implements ValueObject<String>, SelfValidator {

    private final String name;

    private Name(String value) {
        this.name = value;
        selfValidation();
    }

    public static Name of(String value) {
        return new Name(value);
    }

    @Override
    public String get() {
        return this.name;
    }

    @Override
    public void selfValidation() {
        Throws.ifNullOrBlank(this.name, "name must be not null");
    }
}