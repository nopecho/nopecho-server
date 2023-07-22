package io.nopecho.members.services.handlers.query;

import io.nopecho.members.services.ports.in.query.TestQuery;
import io.nopecho.members.services.ports.in.query.TestQueryResult;

public class UserResultConverter {

    public static TestQueryResult convert(TestQuery query) {
        return TestQueryResult.builder()
                .name(query.getName())
                .build();
    }
}
