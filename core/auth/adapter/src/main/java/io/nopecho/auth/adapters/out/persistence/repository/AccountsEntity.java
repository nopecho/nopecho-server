package io.nopecho.auth.adapters.out.persistence.repository;


import io.nopecho.auth.domain.Accounts;
import io.nopecho.members.domain.MemberId;
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
    private final Set<ProviderEntity> providers;

    @MappedCollection(idColumn = "account_id")
    private final Set<RoleEntity> roles;

    @CreatedDate
    private final LocalDateTime createdAt;
    @LastModifiedDate
    private final LocalDateTime modifiedAt;
    @Version
    private final Long version;

    public static AccountsEntity from(Accounts accounts) {
        Set<RoleEntity> roleForm = roleForm(accounts);
        Set<ProviderEntity> providerFrom = providerFrom(accounts);

        return new AccountsEntity(
                null,
                accounts.getMemberId().get(),
                providerFrom,
                roleForm,
                null,
                null,
                null
        );
    }

    private static Set<RoleEntity> roleForm(Accounts accounts) {
        return accounts.getRoles().stream()
                .map(RoleEntity::from)
                .collect(Collectors.toSet());
    }

    private static Set<ProviderEntity> providerFrom(Accounts accounts) {
        return accounts.getProviders().stream()
                .map(ProviderEntity::from)
                .collect(Collectors.toSet());
    }

    public Accounts toDomain() {
        return Accounts.of(
                MemberId.of(this.memberId),
                null,
                null
        );
    }
}
