package io.nopecho.members.domain.policy.grade.factor;

import io.nopecho.members.domain.policy.Factor;
import lombok.Value;

@Value(staticConstructor = "of")
public class OrderCountFactor implements Factor {

    Integer orderCount;

    @Override
    public Class<?> getType() {
        return this.getClass();
    }
}
