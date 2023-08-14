package io.nopecho.auth.interfaces.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginFallbackController {

    @GetMapping("/login/oauth2/fallback")
    public ResponseEntity<?> loginFallbackUrl() {
        return ResponseEntity.status(UNAUTHORIZED).body("로그인 하셈");
    }
}
