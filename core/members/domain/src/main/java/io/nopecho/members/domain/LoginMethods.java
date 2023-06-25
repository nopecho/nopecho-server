package io.nopecho.members.domain;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class LoginMethods {

    private final Set<LoginMethod> methods;

    private LoginMethods(LoginMethod... methods) {
        this.methods = Set.of(methods);
    }

    private LoginMethods(Set<LoginMethod> methods) {
        this.methods = methods;
    }

    public static LoginMethods from(LoginMethod... methods) {
        return new LoginMethods(methods);
    }

    public LoginMethod findMethod(OauthMethod method) {
        return this.methods.stream()
                .filter(m -> m.isEquals(method))
                .findFirst()
                .orElseThrow();
    }

    public LoginMethods add(LoginMethod method) {
        Set<LoginMethod> loginMethods = new HashSet<>(this.methods);
        loginMethods.add(method);
        return new LoginMethods(loginMethods);
    }
}
