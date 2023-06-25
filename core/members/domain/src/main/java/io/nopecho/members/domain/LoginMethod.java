package io.nopecho.members.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginMethod {

    private final OauthMethod method;
    private final LoginToken token;

    public static LoginMethod from(OauthMethod method, LoginToken token) {
        return new LoginMethod(method, token);
    }

    public boolean isEquals(OauthMethod value) {
        return this.method.equals(value);
    }

    public boolean apply(String value) {
        return this.token.isEquals(value);
    }
}
