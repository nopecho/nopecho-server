package io.nopecho.auth.adapters.out.persistence.repository;

import io.nopecho.auth.domain.Provider;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;


@Table("accounts_providers")
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ProviderEntity {

    private final String method;
    private final String token;
    @CreatedDate
    private final LocalDateTime createdAt;
    @LastModifiedDate
    private final LocalDateTime modifiedAt;

    public static ProviderEntity from(Provider provider) {
        return new ProviderEntity(
                provider.getMethod().name(),
                provider.getToken().getValue(),
                null,
                null
        );
    }
}
