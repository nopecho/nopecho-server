package io.nopecho.user.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    @DisplayName("유저 생성 시 userId가 null 일 경우 validation 예외 발생")
    @Test
    void userIdValidation() {
        assertThatThrownBy(() -> User.builder()
                .username(Name.of("name"))
                .email(Email.of("email"))
                .build()
        );
    }

    @DisplayName("유저 생성 시 userId의 value 가 null 일 경우 validation 예외 발생")
    @Test
    void userIdValidation2() {
        assertThatThrownBy(() -> User.builder()
                .id(null)
                .username(Name.of("name"))
                .email(Email.of("email"))
                .build()
        );
    }

    @DisplayName("유저 생성 시 username이 null 일 경우 validation 예외 발생")
    @Test
    void usernameValidation() {
        assertThatThrownBy(() -> User.builder()
                .id(UserId.of(1L))
                .email(Email.of("email"))
                .build()
        );
    }
}