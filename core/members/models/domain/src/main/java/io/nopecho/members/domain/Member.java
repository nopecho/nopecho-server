package io.nopecho.members.domain;

import io.nopecho.utils.LongIdGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;

import java.util.Set;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    private final MemberId id;
    @With
    private final Name name;
    @With
    private final Email email;
    @With
    private final PhoneNumber phoneNumber;
    @With
    private final Roles roles;
    @With
    private final Agreement agreement;

    public static Member of(MemberId id, Name name, Email email, PhoneNumber phoneNumber, Roles roles, Agreement agreement) {
        return new Member(id, name, email, phoneNumber, roles, agreement);
    }

    public static Member of(MemberId id, Name name, Email email, PhoneNumber phoneNumber, Roles roles) {
        Agreement disagreement = Agreement.falseAll();
        return new Member(id, name, email, phoneNumber, roles, disagreement);
    }

    public static Member create(Name name, Email email, PhoneNumber phoneNumber, Agreement agreement) {
        return new Member(MemberId.of(LongIdGenerator.gen()), name, email, phoneNumber, Roles.create(), agreement);
    }

    public static Member create(Name name, Email email, PhoneNumber phoneNumber) {
        Agreement disagreement = Agreement.falseAll();
        return new Member(MemberId.of(LongIdGenerator.gen()), name, email, phoneNumber, Roles.create(), disagreement);
    }

    public Set<Role> getRoles() {
        return this.roles.getRoles();
    }

    public Member modify(Name name) {
        return this.withName(name);
    }

    public Member modify(Email email) {
        return this.withEmail(email);
    }

    public Member modify(PhoneNumber phoneNumber) {
        return this.withPhoneNumber(phoneNumber);
    }

    public Member modify(Name name, Email email, PhoneNumber phoneNumber) {
        return modify(name)
                .modify(email)
                .modify(phoneNumber);
    }

    public Member addRole(Role role) {
        Roles gives = this.roles.add(role);
        return this.withRoles(gives);
    }

    public Member addRoles(Role... role) {
        Roles gives = this.roles.add(role);
        return this.withRoles(gives);
    }

    public Member addRoles(Set<Role> roles) {
        Roles gives = this.roles.add(roles);
        return this.withRoles(gives);
    }

    public boolean hasUser() {
        return this.roles.hasUser();
    }

    public boolean hasAdmin() {
        return this.roles.hasAdmin();
    }

    public boolean hasRole(Role role) {
        return this.roles.hasRole(role);
    }

    public boolean isMultiRoles() {
        return this.roles.count() > 1;
    }

    public int roleCount() {
        return this.roles.count();
    }

    public Member agreeMarketing() {
        Agreement agreeMarketing = this.agreement.agreeMarketing();
        return this.withAgreement(agreeMarketing);
    }

    public Member disagreeMarketing() {
        Agreement disagreeMarketing = this.agreement.disagreeMarketing();
        return this.withAgreement(disagreeMarketing);
    }
}