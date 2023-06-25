package io.nopecho.members.domain;

import lombok.AllArgsConstructor;

import java.util.function.BiPredicate;

@AllArgsConstructor
public enum OauthMethod {
    GOOGLE(String::equals),
    APPLE(String::equals),
    KAKAO(String::equals),
    NONE(String::equals);

    private final BiPredicate<String, String> predicate;
}
