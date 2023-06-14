package io.nopecho.event.adapter.persistence;

import org.springframework.data.repository.CrudRepository;

public interface DomainEventRepository extends CrudRepository<DomainEventEntity, Long> {
}
