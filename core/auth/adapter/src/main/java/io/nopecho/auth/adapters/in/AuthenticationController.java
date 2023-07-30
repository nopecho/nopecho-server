package io.nopecho.auth.adapters.in;

import io.nopecho.auth.domain.Method;
import io.nopecho.auth.services.ports.in.LoginUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationController {

    private final LoginUseCase useCase;

    @PostMapping("/login")
    public ResponseEntity<?> login() {
        Method signMethod = Method.valueOf("");

        useCase.login(signMethod);

        return ResponseEntity.ok("login");
    }
}