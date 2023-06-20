package io.nopecho.user.application.handlers.query;

import io.nopecho.abstraction.query.Query;
import io.nopecho.abstraction.query.QueryHandler;
import io.nopecho.abstraction.query.QueryResult;
import io.nopecho.user.application.port.in.query.TestQuery;
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
        TestQuery testQuery = tryCast(query, TestQuery.class);

        return UserResultConverter.convert(testQuery);
    }
}
