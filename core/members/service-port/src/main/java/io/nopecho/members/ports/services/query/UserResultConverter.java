package io.nopecho.members.ports.services.query;

import io.nopecho.members.ports.in.query.TestQuery;
import io.nopecho.members.ports.in.query.TestQueryResult;

public class UserResultConverter {

    public static TestQueryResult convert(TestQuery query) {
        return TestQueryResult.builder()
                .name(query.getName())
                .build();
    }
}
