package io.nopecho.auth.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSign {

    private final MemberId memberId;
    private final Set<SignProvider> providers;

    public static MemberSign create(MemberId memberId, SignProvider provider) {
        return new MemberSign(memberId, Set.of(provider));
    }

    public MemberSign addProvider(SignProvider provider) {
        HashSet<SignProvider> signProviders = new HashSet<>(this.providers);
        signProviders.add(provider);

        return new MemberSign(this.memberId, signProviders);
    }
}
