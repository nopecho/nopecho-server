package io.nopecho.members.adpater.in;

import io.nopecho.event.EventPayload;
import io.nopecho.members.application.port.in.command.CommandHandleUseCase;
import io.nopecho.members.application.port.in.command.SignupCommand;
import io.nopecho.members.domain.OauthMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommandController {

    private final CommandHandleUseCase commandUseCase;

    @GetMapping("/v1/event")
    public ResponseEntity<?> get(@RequestParam Long id) {
        SignupCommand command = SignupCommand.builder()
                .name("nopecho")
                .email("ch.jooon@gmail.com")
                .loginMethod(OauthMethod.GOOGLE)
                .loginToken("token")
                .build();

        EventPayload event = commandUseCase.handle(command);
        return ResponseEntity.ok(event);
    }
}
