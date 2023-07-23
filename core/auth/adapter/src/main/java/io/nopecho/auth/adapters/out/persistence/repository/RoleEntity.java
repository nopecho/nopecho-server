package io.nopecho.auth.adapters.out.persistence.repository;

import io.nopecho.auth.domain.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("accounts_roles")
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
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
