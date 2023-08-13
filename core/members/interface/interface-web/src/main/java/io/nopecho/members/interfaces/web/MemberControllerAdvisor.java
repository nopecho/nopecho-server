package io.nopecho.members.interfaces.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class MemberControllerAdvisor {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleBadRequest(RuntimeException e) {
        log.warn(e.getMessage());
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(400, e.getMessage()));
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ErrorResponse {
        private Integer code;
        private String message;
    }
}
