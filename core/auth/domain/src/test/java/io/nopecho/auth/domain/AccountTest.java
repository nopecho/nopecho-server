package io.nopecho.auth.domain;

import io.nopecho.members.domain.MemberId;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {
    Account sut;

    @Test
    void create() {
        sut = addAccounts(1L);

        assertThat(sut).isNotNull();
    }

    Account addAccounts(Long memberId) {
        return Account.of(
                MemberId.of(memberId),
                Signatures.from(Signature.of(Method.EMAIL, Token.of("")))
                         );
    }

    Account addAccounts() {
        return Account.of(
                MemberId.of(1L),
                Signatures.from(Signature.of(Method.EMAIL, Token.of("")))
                         );
    }
}