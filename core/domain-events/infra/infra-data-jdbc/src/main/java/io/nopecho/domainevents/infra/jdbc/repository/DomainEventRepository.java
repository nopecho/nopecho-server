package io.nopecho.domainevents.infra.jdbc.repository;

import io.nopecho.domainevents.infra.jdbc.entity.DomainEventEntity;
import org.springframework.data.repository.CrudRepository;

public interface DomainEventRepository extends CrudRepository<DomainEventEntity, Long> {
}
