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
    private final Signatures signatures;
    @With
    private final Roles roles;

    public static Accounts of(MemberId memberId, Signatures Signatures, Roles roles) {
        return new Accounts(memberId, Signatures, roles);
    }

    public MemberId getMemberId() {
        return this.memberId;
    }

    public Set<Signature> getSignatures() {
        return this.signatures.getSignatures();
    }

    public Set<Role> getRoles() {
        return this.roles.getRoles();
    }

    public Accounts addSignature(Signature signature) {
        Signatures added = this.signatures.add(signature);
        return this.withSignatures(added);
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

    public int roleCount() {
        return this.roles.count();
    }
}
