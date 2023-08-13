package io.nopecho.members.domain.policy.grade;

import io.nopecho.members.domain.Grade;
import io.nopecho.members.domain.policy.Factor;
import io.nopecho.members.domain.policy.Policy;

import java.util.List;

public class GradePolicies {

    private final List<Policy<Grade, Factor>> policies;

    public GradePolicies(Policy<Grade, Factor> policies) {
        this.policies = List.of(policies);
    }

    public Grade apply(Factor factor) {
        Policy<Grade, Factor> policy = this.policies.stream()
                .filter(p -> p.canApply(factor))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not Found Applicable Policy."));
        return policy.apply(factor);
    }
}
