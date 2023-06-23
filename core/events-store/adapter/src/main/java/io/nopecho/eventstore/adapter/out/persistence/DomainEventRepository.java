package io.nopecho.eventstore.adapter.out.persistence;

import org.springframework.data.repository.CrudRepository;

public interface DomainEventRepository extends CrudRepository<DomainEventEntity, Long> {
}
