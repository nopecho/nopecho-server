package io.nopecho.user.domain;

import io.nopecho.utils.SelfValidator;
import io.nopecho.utils.ValueObject;
import lombok.Value;

import java.util.Objects;

@Value(staticConstructor = "of")
public class UserId implements ValueObject<Long>, SelfValidator {
    Long id;

    @Override
    public Long get() {
        return this.id;
    }

    @Override
    public void selfValidation() {
        if (Objects.isNull(id)) {
            throw new RuntimeException("user id is can't be null!");
        }
    }
}
