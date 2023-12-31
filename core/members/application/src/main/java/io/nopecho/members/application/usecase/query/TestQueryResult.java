package io.nopecho.members.application.usecase.query;

import io.nopecho.query.QueryResult;
import io.nopecho.utils.Throws;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TestQueryResult implements QueryResult<String, String> {

    private String name;

    private TestQueryResult(String name) {
        this.name = name;
        this.selfValidation();
    }

    @Override
    public void selfValidation() {
        Throws.ifNullOrBlank(this.name, "test query name is can be not null or empty!");
    }

    @Override
    public String onSuccess() {
        return this.name;
    }

    @Override
    public String onFail() {
        return "fail";
    }
}
