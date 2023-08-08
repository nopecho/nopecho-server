package io.nopecho.members.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Roles {

    private final Set<Role> roles;

    public static Roles create() {
        return new Roles(Set.of(Role.USER));
    }

    public static Roles from(Set<Role> roles) {
        return new Roles(roles);
    }

    public static Roles of(Role... roles) {
        Set<Role> roleSet = new HashSet<>(List.of(roles));
        return Roles.from(roleSet);
    }

    public Roles add(Role... roles) {
        Set<Role> role = new HashSet<>(List.of(roles));
        role.addAll(this.roles);
        return Roles.from(role);
    }

    public Roles add(Set<Role> roles) {
        roles.addAll(this.roles);
        return Roles.from(roles);
    }

    public Roles removes(Role... roles) {
        List<Role> removeList = Arrays.stream(roles).toList();
        Set<Role> removedRoles = this.roles.stream()
                .filter(r -> !removeList.contains(r))
                .collect(Collectors.toSet());

        return Roles.from(removedRoles);
    }

    public boolean hasAdmin() {
        return this.roles.stream()
                .anyMatch(Role.ADMIN::equals);
    }

    public boolean hasUser() {
        return this.roles.stream()
                .anyMatch(Role.USER::equals);
    }

    public boolean hasRole(Role role) {
        return this.roles.stream()
                .anyMatch(r -> r.equals(role));
    }

    public int count() {
        return this.roles.size();
    }
}