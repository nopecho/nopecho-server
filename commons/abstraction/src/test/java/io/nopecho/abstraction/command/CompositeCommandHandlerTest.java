package io.nopecho.abstraction.command;

import io.nopecho.abstraction.fake.command.*;
import io.nopecho.command.Command;
import io.nopecho.command.CommandHandler;
import io.nopecho.command.CompositeCommandHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CompositeCommandHandlerTest {

    CompositeCommandHandler sut;

    CommandHandler fakeHandler;
    CommandHandler canNotHandler;
    CommandHandler fake2Handler;

    @BeforeEach
    void setUp() {
        fakeHandler = FakeCommandHandler.isSupport(new FakeCommand());
        canNotHandler = new AlwaysCanNotHandler();
        fake2Handler = FakeCommandHandler.isSupport(new FakeCommand2());

        sut = new FakeCommandHandlers(fakeHandler, canNotHandler, fake2Handler);
    }

    @DisplayName("지원하는 command 를 찾아 handle 한다.")
    @Test
    void handle() {
        Command command = new FakeCommand();
        FakeCommandHandler expect = (FakeCommandHandler) fakeHandler;

        sut.handle(command);

        assertThat(expect.isHandle).isTrue();
    }

    @DisplayName("지원되는 command 가 없으면 RuntimeException 이 발생한다.")
    @Test
    void throwHandle() {
        Command command = new NotSupportCommand();

        assertThatThrownBy(() -> sut.handle(command))
                .isInstanceOf(RuntimeException.class);
    }

    static class FakeCommandHandlers extends CompositeCommandHandler {
        public FakeCommandHandlers(CommandHandler... handlers) {
            super(handlers);
        }
    }
}