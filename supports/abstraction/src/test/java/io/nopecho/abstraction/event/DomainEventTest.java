package io.nopecho.abstraction.event;

import io.nopecho.abstraction.fake.event.FakeEvent;
import io.nopecho.utils.Serializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DomainEventTest {

    DomainEvent sut;
    EventPayload payload;

    @BeforeEach
    void setUp() {
        payload = FakeEvent.of("");
    }

    @DisplayName("DomainEvent of 생성 시 id와 occurredAt이 자동으로 만들어진다.")
    @Test
    void of() {
        sut = DomainEvent.of(payload);

        Long actualId = sut.getId();
        LocalDateTime actualDate = sut.getOccurredAt();

        assertThat(actualId).isNotNull();
        assertThat(actualDate).isNotNull();
    }

    @DisplayName("DomainEvent of 생성 시 payload 가 없으면 RuntimeException 이 발생한다.")
    @Test
    void ofFail() {
        assertThatThrownBy(() -> sut = DomainEvent.of(null))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void getPayload() {
        sut = DomainEvent.of(payload);

        Object actual = sut.getPayload();

        assertThat(actual).isInstanceOf(FakeEvent.class);
    }

    @Test
    void getPayload2() {
        sut = DomainEvent.of(payload);

        FakeEvent actual = sut.getPayload(FakeEvent.class);

        assertThat(actual).isInstanceOf(FakeEvent.class);
    }

    @Test
    void serialize() {
        sut = DomainEvent.of(payload);
        String expect = Serializer.serialize(sut);

        String actual = sut.serialize();

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void deserialize() {
        sut = DomainEvent.of(payload);
        String serialized = sut.serialize();

        DomainEvent actual = DomainEvent.deserialize(serialized);

        assertThat(actual.getType()).isEqualTo(payload.getClass().getTypeName());
    }
}