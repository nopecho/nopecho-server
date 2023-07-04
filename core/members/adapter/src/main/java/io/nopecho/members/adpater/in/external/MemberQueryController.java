package io.nopecho.members.adpater.in.external;

import io.nopecho.members.ports.in.query.MemberQueryHandler;
import io.nopecho.members.ports.in.query.TestQuery;
import io.nopecho.query.QueryResult;
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
public class MemberQueryController {

    private final MemberQueryHandler queryHandler;

    @GetMapping("/v1/test")
    public ResponseEntity<?> get(@RequestParam String name) {
        TestQuery query = TestQuery.builder()
                .name(name)
                .build();

        QueryResult result = queryHandler.handle(query);
        return ResponseEntity.ok(result);
    }
}
