package io.nopecho.auth.infra.jdbc.repository;

import io.nopecho.auth.infra.jdbc.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountJdbcRepository extends CrudRepository<AccountEntity, Long> {
}
