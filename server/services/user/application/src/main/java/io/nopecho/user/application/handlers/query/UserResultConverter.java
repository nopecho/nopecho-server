package io.nopecho.user.application.handlers.query;

import io.nopecho.user.application.port.in.query.TestQuery;
import io.nopecho.user.application.port.in.query.TestQueryResult;

public class UserResultConverter {

    public static TestQueryResult convert(TestQuery query) {
        return TestQueryResult.builder()
                .name(query.getName())
                .build();
    }
}
