package io.nopecho.auth.infra.jdbc.entity;


import io.nopecho.auth.domain.Account;
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

@Table("Account")
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountEntity {

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

    public static AccountEntity from(Account Account) {
        Set<SignatureEntity> signatureEntities = signatureFrom(Account);

        return new AccountEntity(
                LongIdGenerator.gen(),
                Account.getMemberId().get(),
                signatureEntities,
                null,
                null,
                null
        );
    }

    private static Set<SignatureEntity> signatureFrom(Account Account) {
        return Account.getSignatures().stream()
                .map(SignatureEntity::from)
                .collect(Collectors.toSet());
    }

    public Account toDomain() {
        return Account.of(
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
