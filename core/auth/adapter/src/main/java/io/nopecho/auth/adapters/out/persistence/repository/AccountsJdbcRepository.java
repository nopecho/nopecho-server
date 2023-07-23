package io.nopecho.auth.adapters.out.persistence.repository;

import org.springframework.data.repository.CrudRepository;

public interface AccountsJdbcRepository extends CrudRepository<AccountsEntity, Long> {
}
