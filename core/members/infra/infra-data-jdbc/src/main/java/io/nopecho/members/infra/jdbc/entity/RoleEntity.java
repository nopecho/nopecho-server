package io.nopecho.members.infra.jdbc.entity;

import io.nopecho.members.domain.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table("members_roles")
public class RoleEntity {

    private final Role role;

    public static RoleEntity from(Role role) {
        return new RoleEntity(role);
    }
}
