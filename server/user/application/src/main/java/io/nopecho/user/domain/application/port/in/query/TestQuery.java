package io.nopecho.user.domain.application.port.in.query;

import io.nopecho.abstraction.query.Query;
import io.nopecho.utils.Throws;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TestQuery implements Query {

    private String name;

    private TestQuery(String name) {
        this.name = name;
        this.selfValidation();
    }

    @Override
    public void selfValidation() {
        Throws.ifNullOrBlank(this.name, "name is can't be null or empty!");
    }
}
