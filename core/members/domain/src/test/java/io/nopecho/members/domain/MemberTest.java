package io.nopecho.members.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    Member sut;

    Name ANY_NAME = Name.of("ANY");
    Email ANY_EMAIL = Email.of("ANY");
    LoginToken ANY_TOKEN = LoginToken.of("ANY");

    @DisplayName("회원 생성 시 USER 권한을 가진다.")
    @Test
    void createRole() {
        sut = Member.createFrom(ANY_NAME, ANY_EMAIL, LoginMethod.from(OauthMethod.KAKAO, ANY_TOKEN));

        Role actual = sut.getRole();

        assertThat(actual).isEqualTo(Role.USER);
    }

    @DisplayName("회원 생성 시 id는 자동 생성 된다.")
    @Test
    void createId() {
        sut = Member.createFrom(ANY_NAME, ANY_EMAIL, LoginMethod.from(OauthMethod.KAKAO, ANY_TOKEN));

        MemberId actual = sut.getId();
        System.out.println(actual.get());

        assertThat(actual).isNotNull();
        assertThat(actual.get()).isInstanceOf(Long.class);
    }
}