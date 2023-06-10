package io.nopecho.user.domain;

import io.nopecho.utils.SelfValidator;
import io.nopecho.utils.Throws;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User implements SelfValidator {

    private UserId id;
    private Name username;
    private Email email;

    private User(UserId id, Name username, Email email) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.selfValidation();
    }

    @Override
    public void selfValidation() {
        Throws.ifNull(this.id, "user id object is can't be null!");
        Throws.ifNull(this.username, "username object is can't be null!");
        this.id.selfValidation();
        this.username.selfValidation();
        this.email.selfValidation();
    }
}
