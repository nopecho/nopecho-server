package io.nopecho.user.domain.application.port.in.query;

import io.nopecho.abstraction.query.CompositeQueryHandler;
import io.nopecho.abstraction.query.QueryHandler;

public class UserQueryHandler extends CompositeQueryHandler {

    public UserQueryHandler(QueryHandler... handlers) {
        super(handlers);
    }
}
