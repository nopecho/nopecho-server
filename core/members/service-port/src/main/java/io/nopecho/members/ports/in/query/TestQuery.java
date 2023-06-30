package io.nopecho.members.ports.in.query;

import io.nopecho.query.Query;
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

    @Override
    public boolean isType(Class<? extends Query> clazz) {
        return this.getClass().equals(clazz);
    }
}
