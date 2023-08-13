package io.nopecho.auth.application;

import io.nopecho.auth.application.usecase.LoginUseCase;
import io.nopecho.auth.domain.Method;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService implements LoginUseCase {
    @Override
    public void login(Method method) {
        log.info(method.name());
    }
}
