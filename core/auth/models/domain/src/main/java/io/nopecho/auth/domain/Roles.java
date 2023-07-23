package io.nopecho.auth.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Roles gives(Role... roles) {
        Set<Role> role = new HashSet<>(List.of(roles));
        role.addAll(this.roles);
        return Roles.from(role);
    }

    public Roles gives(Set<Role> roles) {
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

    public boolean isExistAdmin() {
        return this.roles.stream()
                .anyMatch(Role.ADMIN::equals);
    }

    public boolean isExistUser() {
        return this.roles.stream()
                .anyMatch(Role.USER::equals);
    }

    public boolean isOnlyUser() {
        return isNoneAdmin() && isExistUser();
    }

    public boolean isNoneAdmin() {
        return this.roles.stream()
                .noneMatch(Role.ADMIN::equals);
    }

    public int size() {
        return this.roles.size();
    }
}