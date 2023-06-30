package io.nopecho.members.ports.services.query;

import io.nopecho.members.ports.in.query.TestQuery;
import io.nopecho.query.Query;
import io.nopecho.query.QueryHandler;
import io.nopecho.query.QueryResult;
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
