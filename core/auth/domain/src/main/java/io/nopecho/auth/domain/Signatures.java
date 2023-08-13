package io.nopecho.auth.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Signatures {

    private final Set<Signature> signatures;

    public static Signatures from(Set<Signature> signatures) {
        return new Signatures(signatures);
    }

    public static Signatures from(Signature signature) {
        return Signatures.of(signature);
    }

    public static Signatures of(Signature... signature) {
        Set<Signature> signatures = new HashSet<>(List.of(signature));
        return Signatures.from(signatures);
    }

    public boolean verify(Signature signature) {
        return this.signatures.stream()
                .anyMatch(s -> s.equals(signature));
    }

    public Signatures add(Signature... signature) {
        Set<Signature> signatures = new HashSet<>(List.of(signature));
        signatures.addAll(this.signatures);

        return Signatures.from(signatures);
    }

    public Signatures add(Set<Signature> signatures) {
        signatures.addAll(this.signatures);

        return Signatures.from(signatures);
    }
}
