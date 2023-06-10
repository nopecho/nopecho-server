package io.nopecho.user.domain;

import io.nopecho.utils.SelfValidator;
import io.nopecho.utils.ValueObject;
import lombok.Value;

@Value(staticConstructor = "of")
public class Name implements ValueObject<String>, SelfValidator {

    String value;

    @Override
    public String get() {
        return this.value;
    }

    @Override
    public void selfValidation() {
        if (value.length() <= 1) {
            throw new RuntimeException("name length is can't be 1!");
        }
    }
}
