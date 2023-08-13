package io.nopecho.auth.infra.jdbc;

import io.nopecho.auth.domain.Account;
import io.nopecho.auth.infra.jdbc.entity.AccountEntity;
import io.nopecho.auth.infra.jdbc.repository.AccountJdbcRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AccountPersistAdapter {

    private final AccountJdbcRepository repository;

    public Account save(Account accounts) {
        AccountEntity entity = AccountEntity.from(accounts);
        return repository.save(entity).toDomain();
    }
}
