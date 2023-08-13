package io.nopecho.members.domain;

import io.nopecho.utils.SelfValidator;
import io.nopecho.utils.Throws;

public class Agreement implements SelfValidator {
    private final Boolean isMarketing;

    private Agreement(Boolean isMarketing) {
        this.isMarketing = isMarketing;
        selfValidation();
    }

    public static Agreement of(Boolean isMarketing) {
        return new Agreement(isMarketing);
    }

    public static Agreement falseAll() {
        return new Agreement(false);
    }

    public boolean isMarketing() {
        return this.isMarketing;
    }

    public Agreement agreeMarketing() {
        return new Agreement(true);
    }

    public Agreement disagreeMarketing() {
        return new Agreement(false);
    }

    @Override
    public void selfValidation() {
        Throws.ifNull(this.isMarketing, "agreement must be not null");
    }
}
