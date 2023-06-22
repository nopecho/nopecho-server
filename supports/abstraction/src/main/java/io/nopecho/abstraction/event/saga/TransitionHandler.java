package io.nopecho.abstraction.event.saga;

import io.nopecho.abstraction.command.Command;
import io.nopecho.abstraction.event.DomainEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class TransitionHandler implements EventTransitionHandler {

    private final Set<EventTransition<?, ?>> transitions;

    protected TransitionHandler(Set<EventTransition<?, ?>> transitions) {
        this.transitions = transitions;
    }

    public static TransactionManagerBuilder builder() {
        return new TransactionManagerBuilder();
    }

    @Override
    public Command nextTransition(DomainEvent event) {
        EventTransition<?, ?> transition = findTransition(event);

        return transition.apply(event);
    }

    private EventTransition<?, ?> findTransition(DomainEvent event) {
        return this.transitions.stream()
                .filter(t -> t.isSupport(event))
                .findFirst()
                .orElse(new VoidTransition());
    }

    public static class TransactionManagerBuilder {
        private final Set<EventTransition<?, ?>> transactions = new HashSet<>();

        public TransactionManagerBuilder register(Supplier<EventTransition<?, ?>> transaction) {
            this.transactions.add(transaction.get());
            return this;
        }

        public TransactionManagerBuilder register(EventTransition<?, ?> transaction) {
            this.transactions.add(transaction);
            return this;
        }

        public TransitionHandler build() {
            return new TransitionHandler(this.transactions);
        }
    }
}