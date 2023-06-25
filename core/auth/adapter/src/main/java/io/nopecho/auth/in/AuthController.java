package io.nopecho.auth.in;

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
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login() {
        return ResponseEntity.ok("login");
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup() {
        return ResponseEntity.ok("signup");
    }
}
