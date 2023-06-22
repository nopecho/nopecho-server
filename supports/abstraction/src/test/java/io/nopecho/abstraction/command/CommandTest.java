package io.nopecho.abstraction.command;

import io.nopecho.abstraction.fake.command.FakeCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CommandTest {

    @DisplayName("Command 는 validation 실패 시 예외를 발생 시킨다.")
    @Test
    void selfValidationTest() {
        Command sut = FakeCommand.isValid(false);

        assertThatThrownBy(sut::selfValidation);
    }
}
