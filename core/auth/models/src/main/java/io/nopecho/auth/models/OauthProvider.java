package io.nopecho.auth.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class OauthProvider implements SignProvider {

    private final SignMethod method;
    private final SignToken token;

    @Override
    public SignToken getToken() {
        return this.token;
    }

    @Override
    public SignMethod getSignMethod() {
        return this.method;
    }
}