package io.nopecho.user.domain.application.port.in.query;

import io.nopecho.abstraction.query.QueryResult;
import io.nopecho.utils.Throws;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TestQueryResult implements QueryResult {

    private String name;

    private TestQueryResult(String name) {
        this.name = name;
        this.selfValidation();
    }

    @Override
    public void selfValidation() {
        Throws.ifNullOrBlank(this.name, "name is can't be null or empty!");
    }
}
