package io.nopecho.abstraction.event;


import io.nopecho.abstraction.fake.event.FakeEvent;
import io.nopecho.abstraction.fake.event.FakeEventHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DomainEventHandlerTest {

    DomainEventHandler sut;
    DomainEvent event;
    EventPayload payload;

    @BeforeEach
    void setUp() {
        payload = FakeEvent.of("");
        event = DomainEvent.of(payload);
        sut = FakeEventHandler.supportEvent(event);
    }

    @Test
    void canHandle() {
        DomainEvent domainEvent = DomainEvent.of(FakeEvent.of(""));

        boolean actual = sut.canHandle(domainEvent);

        assertThat(actual).isTrue();
    }

    @Test
    void handle() {
        DomainEvent domainEvent = DomainEvent.of(FakeEvent.of(""));
        FakeEventHandler fakeEventHandler = fakeEventHandler();
        assertThat(fakeEventHandler.isHandle).isFalse();

        sut.handle(domainEvent);

        assertThat(fakeEventHandler.isHandle).isTrue();
    }

    private FakeEventHandler fakeEventHandler() {
        return (FakeEventHandler) sut;
    }
}