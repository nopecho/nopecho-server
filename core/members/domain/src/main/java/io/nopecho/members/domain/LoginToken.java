package io.nopecho.members.domain;

import io.nopecho.domain.ValueObject;
import lombok.Value;

@Value(staticConstructor = "of")
public class LoginToken implements ValueObject<String> {

    String token;

    @Override
    public String get() {
        return this.token;
    }

    public boolean isEquals(String value) {
        return this.token.equals(value);
    }
}
