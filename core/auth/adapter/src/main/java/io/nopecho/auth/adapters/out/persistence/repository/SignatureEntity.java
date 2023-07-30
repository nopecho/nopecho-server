package io.nopecho.auth.adapters.out.persistence.repository;

import io.nopecho.auth.domain.Method;
import io.nopecho.auth.domain.Signature;
import io.nopecho.auth.domain.Token;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;


@Table("accounts_signatures")
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SignatureEntity {

    private final Method method;
    private final String token;
    @CreatedDate
    private final LocalDateTime createdAt;
    @LastModifiedDate
    private final LocalDateTime modifiedAt;

    public static SignatureEntity from(Signature signature) {
        return new SignatureEntity(
                signature.getMethod(),
                signature.getToken().getValue(),
                null,
                null
        );
    }

    public Signature toSignature() {
        return Signature.of(method, Token.of(token));
    }
}
