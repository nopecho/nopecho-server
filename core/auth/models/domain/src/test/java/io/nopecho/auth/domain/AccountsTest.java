package io.nopecho.auth.domain;

import io.nopecho.members.domain.MemberId;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountsTest {
    Accounts sut;

    @Test
    void create() {
        sut = addAccounts(1L);

        assertThat(sut).isNotNull();
    }

    @Test
    void create2() {
        sut = addAccounts(1L);

        boolean actual = sut.isOnlyUser();

        assertThat(actual).isTrue();
    }

    @Test
    void create3() {
        sut = addAccounts(1L);

        boolean actual = sut.isNoneAdmin();

        assertThat(actual).isTrue();
    }

    @Test
    void addRole() {
        sut = addAccounts(1L);

        Accounts accounts = sut.giveRole(Role.ADMIN);
        boolean actual = accounts.isAdmin();
        int actual2 = accounts.roleCount();

        assertThat(actual).isTrue();
        assertThat(actual2).isEqualTo(2);
    }

    @Test
    void addRoles() {
        sut = addAccounts(1L);

        Accounts accounts = sut.giveRoles(Role.ADMIN, Role.ADMIN, Role.USER, Role.USER);
        int actual = accounts.roleCount();

        assertThat(actual).isEqualTo(2);
    }

    Accounts addAccounts(Long memberId) {
        return Accounts.of(
                MemberId.of(memberId),
                Signatures.from(Signature.of(Method.EMAIL, Token.of(""))),
                Roles.create()
        );
    }

    Accounts addAccounts(Role... roles) {
        return Accounts.of(
                MemberId.of(1L),
                Signatures.from(Signature.of(Method.EMAIL, Token.of(""))),
                Roles.of(roles)
        );
    }
}