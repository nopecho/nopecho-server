package io.nopecho.members.application.handlers.query;

import io.nopecho.members.application.usecase.query.TestQuery;
import io.nopecho.members.application.usecase.query.TestQueryResult;

public class UserResultConverter {

    public static TestQueryResult convert(TestQuery query) {
        return TestQueryResult.builder()
                .name(query.getName())
                .build();
    }
}
