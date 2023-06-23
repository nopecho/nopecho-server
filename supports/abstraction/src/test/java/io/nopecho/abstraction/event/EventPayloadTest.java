package io.nopecho.abstraction.event;

import io.nopecho.event.EventPayload;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EventPayloadTest {

    EventPayload sut;

    @DisplayName("tryCasting 시 타입이 맞지 않으면 RuntimeException 발생")
    @Test
    void payloadTryCastFail() {
        sut = new FakeEvent();

        assertThatThrownBy(() -> sut.tryCast(TestEvent.class))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("tryCasting 시 타입이 맞으면 형변환")
    @Test
    void payloadTryCastSuccess() {
        sut = new FakeEvent();

        FakeEvent actual = sut.tryCast(FakeEvent.class);

        assertThat(actual).isInstanceOf(FakeEvent.class);
    }

    @DisplayName("package 가 다른 동일 이름의 클래스 형변환 시 실패")
    @Test
    void payloadTryCastFailPackage() {
        sut = io.nopecho.abstraction.fake.event.FakeEvent.of("");

        assertThatThrownBy(() -> sut.tryCast(FakeEvent.class))
                .isInstanceOf(RuntimeException.class);
    }

    static class TestEvent implements EventPayload {

    }

    static class FakeEvent implements EventPayload {
    }
}