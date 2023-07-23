package io.nopecho.auth.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Providers {

    private final Set<Provider> providers;

    public static Providers from(Set<Provider> providers) {
        return new Providers(providers);
    }

    public static Providers from(Provider provider) {
        return Providers.of(provider);
    }

    public static Providers of(Provider... provider) {
        Set<Provider> providers = new HashSet<>(List.of(provider));
        return Providers.from(providers);
    }

    public Providers add(Provider... provider) {
        Set<Provider> providers = new HashSet<>(List.of(provider));
        providers.addAll(this.providers);

        return Providers.from(providers);
    }

    public Providers add(Set<Provider> providers) {
        providers.addAll(this.providers);

        return Providers.from(providers);
    }
}
