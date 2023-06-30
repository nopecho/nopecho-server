package io.nopecho.auth.models;

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
public class MemberRole {

    private final MemberId memberId;
    private final Set<Role> roles;

    public static MemberRole create(MemberId memberId) {
        return new MemberRole(memberId, Set.of(Role.USER));
    }

    public static MemberRole from(MemberId memberId, Set<Role> roles) {
        return new MemberRole(memberId, roles);
    }

    public MemberRole gives(Role... roles) {
        HashSet<Role> withRoles = new HashSet<>(this.roles);
        withRoles.addAll(List.of(roles));

        return new MemberRole(this.memberId, withRoles);
    }

    public MemberRole removes(Role... roles) {
        List<Role> removeList = Arrays.stream(roles).toList();
        Set<Role> removedRoles = this.roles.stream()
                .filter(r -> !removeList.contains(r))
                .collect(Collectors.toSet());

        return new MemberRole(this.memberId, removedRoles);
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