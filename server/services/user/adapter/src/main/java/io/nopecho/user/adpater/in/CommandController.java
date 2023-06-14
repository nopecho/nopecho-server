package io.nopecho.user.adpater.in;

import io.nopecho.user.application.port.in.command.UserCommandHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommandController {

    private final UserCommandHandler commandHandler;
}
