package io.nopecho.members.services.ports.in.query;

import io.nopecho.query.CompositeQueryHandler;
import io.nopecho.query.QueryHandler;

public class MemberQueryHandler extends CompositeQueryHandler {

    public MemberQueryHandler(QueryHandler... handlers) {
        super(handlers);
    }
}