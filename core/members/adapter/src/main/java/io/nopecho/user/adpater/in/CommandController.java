package io.nopecho.user.adpater.in;

import io.nopecho.abstraction.event.EventPayload;
import io.nopecho.user.application.port.in.command.TestCommand;
import io.nopecho.user.application.port.in.command.UserCommandUseCase;
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

    private final UserCommandUseCase commandUseCase;

    @GetMapping("/v1/event")
    public ResponseEntity<?> get(@RequestParam Long id) {
        TestCommand command = TestCommand.builder()
                .id(id)
                .build();

        EventPayload event = commandUseCase.handle(command);
        return ResponseEntity.ok(event);
    }
}
