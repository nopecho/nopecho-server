package io.nopecho.members.ports.in.query;

import io.nopecho.query.CompositeQueryHandler;
import io.nopecho.query.QueryHandler;

public class UserQueryHandler extends CompositeQueryHandler {

    public UserQueryHandler(QueryHandler... handlers) {
        super(handlers);
    }
}
