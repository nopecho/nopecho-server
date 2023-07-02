package io.nopecho.auth.models;

import io.nopecho.domain.ValueObject;
import io.nopecho.utils.SelfValidator;
import io.nopecho.utils.Throws;
import lombok.Value;

@Value(staticConstructor = "of")
public class MemberId implements ValueObject<Long>, SelfValidator {

    Long id;

    private MemberId(Long id) {
        this.id = id;
        selfValidation();
    }

    @Override
    public Long getValue() {
        return this.id;
    }

    @Override
    public void selfValidation() {
        Throws.ifNull(this.id, "member id must be not null");
    }
}
