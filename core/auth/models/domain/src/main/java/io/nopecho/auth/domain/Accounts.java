package io.nopecho.auth.domain;

import io.nopecho.members.domain.MemberId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;

import java.util.Set;

@Getter
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

    public Accounts addProvider(Provider provider) {
        Providers added = this.providers.add(provider);
        return this.withProviders(added);
    }

    public Accounts giveRole(Role role) {
        Roles gives = this.roles.gives(role);
        return this.withRoles(gives);
    }

    public Accounts giveRoles(Role... role) {
        Roles gives = this.roles.gives(role);
        return this.withRoles(gives);
    }

    public Accounts giveRoles(Set<Role> roles) {
        Roles gives = this.roles.gives(roles);
        return this.withRoles(gives);
    }
}
