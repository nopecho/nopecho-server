package io.nopecho.user.domain.adpater.in;

import io.nopecho.abstraction.query.QueryResult;
import io.nopecho.user.domain.application.port.in.query.TestQuery;
import io.nopecho.user.domain.application.port.in.query.UserQueryHandler;
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
public class QueryController {

    private final UserQueryHandler queryHandler;

    @GetMapping("/v1/test")
    public ResponseEntity<?> get(@RequestParam String name) {
        TestQuery query = TestQuery.builder()
                .name(name)
                .build();

        QueryResult result = queryHandler.handle(query);
        return ResponseEntity.ok(result);
    }
}
