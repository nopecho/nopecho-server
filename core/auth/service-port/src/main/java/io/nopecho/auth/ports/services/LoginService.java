package io.nopecho.auth.ports.services;

import io.nopecho.auth.models.SignMethod;
import io.nopecho.auth.ports.in.LoginUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService implements LoginUseCase {
    @Override
    public void login(SignMethod method) {
        log.info(method.name());
    }
}
