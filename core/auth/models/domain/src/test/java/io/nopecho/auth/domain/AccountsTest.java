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

    Accounts addAccounts(Long memberId) {
        return Accounts.of(
                MemberId.of(memberId),
                Signatures.from(Signature.of(Method.EMAIL, Token.of("")))
        );
    }

    Accounts addAccounts() {
        return Accounts.of(
                MemberId.of(1L),
                Signatures.from(Signature.of(Method.EMAIL, Token.of("")))
        );
    }
}