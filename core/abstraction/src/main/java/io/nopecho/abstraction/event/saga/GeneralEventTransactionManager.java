package io.nopecho.abstraction.event.saga;


import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.abstraction.event.EventPayload;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public final class GeneralEventTransactionManager implements EventTransactionManager {

    private final Set<EventTransaction<?, ?>> transactions;

    private GeneralEventTransactionManager(Set<EventTransaction<?, ?>> transactions) {
        this.transactions = transactions;
    }

    public static EventTransactionManagerBuilder builder() {
        return new EventTransactionManagerBuilder();
    }

    @Override
    public DomainEvent commit(DomainEvent event) {
        EventTransaction<?, ?> transaction = findTransactionBy(event);

        EventPayload commitEvent = transaction.getCommitEvent(event);
        return DomainEvent.of(commitEvent);
    }

    @Override
    public DomainEvent rollback(DomainEvent event) {
        EventTransaction<?, ?> transaction = findTransactionBy(event);

        EventPayload compensationEvent = transaction.getCompensationEvent(event);
        return DomainEvent.of(compensationEvent);
    }

    private EventTransaction<?, ?> findTransactionBy(DomainEvent event) {
        return this.transactions.stream()
                .filter(t -> t.isSupport(event))
                .findFirst()
                .orElse(new VoidTransaction());
    }

    public static class EventTransactionManagerBuilder {
        private final Set<EventTransaction<?, ?>> transactions = new HashSet<>();

        public EventTransactionManagerBuilder register(Supplier<EventTransaction<?, ?>> transaction) {
            this.transactions.add(transaction.get());
            return this;
        }

        public EventTransactionManagerBuilder register(EventTransaction<?, ?> transaction) {
            this.transactions.add(transaction);
            return this;
        }

        public GeneralEventTransactionManager build() {
            return new GeneralEventTransactionManager(this.transactions);
        }
    }
}