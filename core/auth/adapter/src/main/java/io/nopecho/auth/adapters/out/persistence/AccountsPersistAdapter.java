package io.nopecho.auth.adapters.out.persistence;

import io.nopecho.auth.adapters.out.persistence.repository.AccountsEntity;
import io.nopecho.auth.adapters.out.persistence.repository.AccountsJdbcRepository;
import io.nopecho.auth.domain.Accounts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AccountsPersistAdapter {

    private final AccountsJdbcRepository repository;

    public Accounts create(Accounts accounts) {
        AccountsEntity entity = AccountsEntity.from(accounts);
        return repository.save(entity).toDomain();
    }
}
