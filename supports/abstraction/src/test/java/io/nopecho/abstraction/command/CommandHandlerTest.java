package io.nopecho.abstraction.command;

import io.nopecho.abstraction.fake.command.FakeCommand;
import io.nopecho.abstraction.fake.command.FakeCommandHandler;
import io.nopecho.abstraction.fake.command.NotSupportCommand;
import io.nopecho.command.Command;
import io.nopecho.command.CommandHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandHandlerTest {

    CommandHandler sut;

    Command command = FakeCommand.of();

    @DisplayName("지원하는 Command를 확인한다.")
    @Test
    void canHandleTrueTest() {
        sut = FakeCommandHandler.isSupport(command);

        boolean actual = sut.canHandle(command);

        assertThat(actual).isTrue();
    }

    @DisplayName("지원하지 않는 Command를 확인한다.")
    @Test
    void canHandleFalseTest() {
        sut = FakeCommandHandler.isSupport(command);
        Command notSupportCommand = new NotSupportCommand();

        boolean actual = sut.canHandle(notSupportCommand);

        assertThat(actual).isFalse();
    }

    @DisplayName("지원하는 Command 를 handle 한다.")
    @Test
    void handleTest() {
        sut = FakeCommandHandler.isSupport(command);
        FakeCommandHandler expect = (FakeCommandHandler) sut;
        assertThat(expect.isHandle).isFalse();

        sut.handle(command);

        assertThat(expect.isHandle).isTrue();
    }

    @DisplayName("지원하지 않는 Command 는 handle 하지 않는다.")
    @Test
    void notHandleTest() {
        Command notSupportCommand = new NotSupportCommand();
        sut = FakeCommandHandler.isSupport(command);

        sut.handle(notSupportCommand);

        FakeCommandHandler expect = (FakeCommandHandler) sut;
        assertThat(expect.isHandle).isFalse();
    }

    @DisplayName("지원하는 Command 만 casting 한다.")
    @Test
    void tryCastTest() {
        sut = FakeCommandHandler.isSupport(command);

        FakeCommand actual = sut.tryCast(command, FakeCommand.class);

        assertThat(actual).isNotNull();
    }

    @DisplayName("지원하지 않는 Command casting 시 예외가 발생한다.")
    @Test
    void catchCastTest() {
        Command notSupportCommand = new NotSupportCommand();
        sut = FakeCommandHandler.isSupport(command);

        assertThatThrownBy(() -> sut.tryCast(notSupportCommand, FakeCommand.class));
    }
}