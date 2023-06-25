package io.nopecho.members.domain;

import io.nopecho.utils.LongIdGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    private final MemberId id;
    @With
    private final Name name;
    @With
    private final Email email;
    @With
    private final LoginMethods loginMethods;

    @With
    private final Role role;

    public static Member from(MemberId id, Name name, Email email, LoginMethods methods, Role role) {
        return new Member(id, name, email, methods, role);
    }

    public static Member createFrom(Name name, Email email, LoginMethod method) {
        LoginMethods methods = LoginMethods.from(method);
        return new Member(MemberId.of(LongIdGenerator.gen()), name, email, methods, Role.USER);
    }

    public boolean login(OauthMethod method, String token) {
        LoginMethod loginMethod = this.loginMethods.findMethod(method);

        return loginMethod.apply(token);
    }
}
