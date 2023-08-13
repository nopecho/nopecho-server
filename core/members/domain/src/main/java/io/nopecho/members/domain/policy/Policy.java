package io.nopecho.members.domain.policy;

public interface Policy<T, F extends Factor> {
    boolean canApply(Factor factor);
    T apply(F factor);
}
