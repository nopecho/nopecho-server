package io.nopecho.auth.adapters.out.persistence.repository;


import io.nopecho.auth.domain.Accounts;
import io.nopecho.auth.domain.Signature;
import io.nopecho.auth.domain.Signatures;
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

    @CreatedDate
    private final LocalDateTime createdAt;
    @LastModifiedDate
    private final LocalDateTime modifiedAt;
    @Version
    private final Long version;

    public static AccountsEntity from(Accounts accounts) {
        Set<SignatureEntity> signatureEntities = signatureFrom(accounts);

        return new AccountsEntity(
                LongIdGenerator.gen(),
                accounts.getMemberId().get(),
                signatureEntities,
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
    public Accounts toDomain() {
        return Accounts.of(
                MemberId.of(this.memberId),
                toSignatures()
        );
    }

    private Signatures toSignatures() {
        Set<Signature> signatureSet = this.signatures.stream()
                .map(SignatureEntity::toSignature)
                .collect(Collectors.toSet());
        return Signatures.from(signatureSet);
    }
}
