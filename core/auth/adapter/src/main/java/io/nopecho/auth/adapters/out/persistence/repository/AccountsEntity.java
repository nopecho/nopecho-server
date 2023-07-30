package io.nopecho.auth.adapters.out.persistence.repository;


import io.nopecho.auth.domain.*;
import io.nopecho.members.domain.MemberId;
import io.nopecho.utils.LongIdGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Table("accounts")
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountsEntity {

    @Id
    private final Long id;

    private final Long memberId;

    @MappedCollection(idColumn = "account_id")
    private final Set<SignatureEntity> signatures;

    @MappedCollection(idColumn = "account_id")
    private final Set<RoleEntity> roles;

    @CreatedDate
    private final LocalDateTime createdAt;
    @LastModifiedDate
    private final LocalDateTime modifiedAt;
    @Version
    private final Long version;

    public static AccountsEntity from(Accounts accounts) {
        Set<RoleEntity> roleEntities = roleForm(accounts);
        Set<SignatureEntity> signatureEntities = signatureFrom(accounts);

        return new AccountsEntity(
                LongIdGenerator.gen(),
                accounts.getMemberId().get(),
                signatureEntities,
                roleEntities,
                null,
                null,
                null
        );
    }

    private static Set<SignatureEntity> signatureFrom(Accounts accounts) {
        return accounts.getSignatures().stream()
                .map(SignatureEntity::from)
                .collect(Collectors.toSet());
    }

    private static Set<RoleEntity> roleForm(Accounts accounts) {
        return accounts.getRoles().stream()
                .map(RoleEntity::from)
                .collect(Collectors.toSet());
    }

    public Accounts toDomain() {
        return Accounts.of(
                MemberId.of(this.memberId),
                toSignatures(),
                toRoles()
        );
    }

    private Roles toRoles() {
        Set<Role> roleSet = this.roles.stream()
                .map(RoleEntity::getRole)
                .collect(Collectors.toSet());
        return Roles.from(roleSet);
    }

    private Signatures toSignatures() {
        Set<Signature> signatureSet = this.signatures.stream()
                .map(SignatureEntity::toSignature)
                .collect(Collectors.toSet());
        return Signatures.from(signatureSet);
    }
}
