package io.nopecho.auth.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
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

    public Roles gives(Role... roles) {
        this.roles.addAll(List.of(roles));

        return Roles.from(this.roles);
    }

    public Roles gives(Set<Role> roles) {
        this.roles.addAll(roles);

        return Roles.from(this.roles);
    }

    public Roles removes(Role... roles) {
        List<Role> removeList = Arrays.stream(roles).toList();
        Set<Role> removedRoles = this.roles.stream()
                .filter(r -> !removeList.contains(r))
                .collect(Collectors.toSet());

        return new Roles(removedRoles);
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
}