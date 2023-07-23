package io.nopecho.auth.domain;

import io.nopecho.members.domain.MemberId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.With;

import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Accounts {

    private final MemberId memberId;
    @With
    private final Providers providers;
    @With
    private final Roles roles;

    public static Accounts of(MemberId memberId, Providers Providers, Roles roles) {
        return new Accounts(memberId, Providers, roles);
    }

    public Accounts add(Provider provider) {
        Providers added = this.providers.add(provider);
        return this.withProviders(added);
    }

    public Accounts give(Role role) {
        Roles gives = this.roles.gives(role);
        return this.withRoles(gives);
    }

    public Accounts gives(Role... role) {
        Roles gives = this.roles.gives(role);
        return this.withRoles(gives);
    }

    public Accounts gives(Set<Role> roles) {
        Roles gives = this.roles.gives(roles);
        return this.withRoles(gives);
    }

    public boolean isOnlyUser() {
        return this.roles.isOnlyUser();
    }

    public boolean isUser() {
        return this.roles.isExistUser();
    }

    public boolean isAdmin() {
        return this.roles.isExistAdmin();
    }

    public boolean isNoneAdmin() {
        return this.roles.isNoneAdmin();
    }

    public int roleSize() {
        return this.roles.size();
    }
}
