package io.nopecho.auth.domain;

import io.nopecho.members.domain.MemberId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;

import java.util.Set;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    private final MemberId memberId;
    @With
    private final Signatures signatures;

    public static Account of(MemberId memberId, Signatures Signatures) {
        return new Account(memberId, Signatures);
    }

    public Set<Signature> getSignatures() {
        return this.signatures.getSignatures();
    }

    public Account addSignature(Signature signature) {
        Signatures added = this.signatures.add(signature);
        return this.withSignatures(added);
    }
}
