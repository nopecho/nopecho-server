package io.nopecho.user.domain;

import io.nopecho.utils.SelfValidator;
import io.nopecho.utils.ValueObject;
import lombok.Value;

@Value(staticConstructor = "of")
public class Email implements ValueObject<String>, SelfValidator {

    String value;

    @Override
    public String get() {
        return this.value;
    }

    @Override
    public void selfValidation() {

    }
}
