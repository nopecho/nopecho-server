package io.nopecho.members.models;

import io.nopecho.domain.RootId;
import io.nopecho.utils.SelfValidator;
import io.nopecho.utils.Throws;
import lombok.Value;

@Value(staticConstructor = "of")
public class MemberId implements RootId<Long>, SelfValidator {

    Long id;

    @Override
    public Long get() {
        return this.id;
    }

    @Override
    public void selfValidation() {
        Throws.ifNull(this.id, "member id must be not null!");
    }
}
