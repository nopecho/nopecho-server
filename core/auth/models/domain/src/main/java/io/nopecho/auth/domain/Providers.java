package io.nopecho.auth.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Providers {

    private final Set<Provider> providers;

    public static Providers from(Set<Provider> providers) {
        return new Providers(providers);
    }

    public static Providers of(Provider... provider) {
        HashSet<Provider> providers = new HashSet<>(List.of(provider));
        return Providers.from(providers);
    }

    public Providers add(Provider provider) {
        this.providers.add(provider);

        return Providers.from(this.providers);
    }
}
