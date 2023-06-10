package io.nopecho.user.domain.application.handlers.query;

import io.nopecho.abstraction.query.Query;
import io.nopecho.abstraction.query.QueryHandler;
import io.nopecho.abstraction.query.QueryResult;
import io.nopecho.user.domain.application.port.in.query.TestQuery;
import io.nopecho.user.domain.application.port.in.query.TestQueryResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestQueryHandler implements QueryHandler {

    @Override
    public boolean canHandle(Query query) {
        return query.getClass().equals(TestQuery.class);
    }

    @Override
    public QueryResult handle(Query query) {
        TestQuery testQuery = convert(query, TestQuery.class);

        return TestQueryResult.builder()
                .name(testQuery.getName())
                .build();
    }
}
