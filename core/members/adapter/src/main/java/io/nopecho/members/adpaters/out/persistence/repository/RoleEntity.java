package io.nopecho.members.adpaters.out.persistence.repository;

import io.nopecho.members.domain.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table("members_roles")
public class RoleEntity {

    private final Role role;
    @CreatedDate
    private final LocalDateTime createdAt;
    @LastModifiedDate
    private final LocalDateTime modifiedAt;

    public static RoleEntity from(Role role) {
        return new RoleEntity(role, null, null);
    }
}
