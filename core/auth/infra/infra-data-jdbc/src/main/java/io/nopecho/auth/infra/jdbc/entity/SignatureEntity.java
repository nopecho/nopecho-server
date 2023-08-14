package io.nopecho.auth.infra.jdbc.entity;

import io.nopecho.auth.domain.Method;
import io.nopecho.auth.domain.Signature;
import io.nopecho.auth.domain.Token;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.relational.core.mapping.Table;

@Table("accounts_signatures")
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SignatureEntity {

    private final Method method;
    private final String token;

    public static SignatureEntity from(Signature signature) {
        return new SignatureEntity(
                signature.getMethod(),
                signature.getToken().getValue()
        );
    }

    public Signature toSignature() {
        return Signature.of(method, Token.of(token));
    }
}
