package io.nopecho.springevents.adapters.out.persistence;

import org.springframework.data.repository.CrudRepository;

public interface DomainEventRepository extends CrudRepository<DomainEventEntity, Long> {
}
