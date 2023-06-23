package io.nopecho.query;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class CompositeQueryHandler implements QueryHandler {

    private final List<QueryHandler> handlers;

    protected CompositeQueryHandler(QueryHandler... handlers) {
        this.handlers = Collections.unmodifiableList(Arrays.asList(handlers));
    }

    @Override
    public boolean canHandle(Query Query) {
        return this.handlers.stream()
                .anyMatch(h -> h.canHandle(Query));
    }

    @Override
    public QueryResult handle(Query Query) {
        return handleOrThrow(Query);
    }

    private QueryResult handleOrThrow(Query Query) {
        QueryHandler handler = findHandlerOrThrow(Query);
        try {
            return handler.handle(Query);
        } catch (Exception e) {
            throw new RuntimeException(
                    String.format("error from [%s]. message: %s", getQueryName(Query), e.getMessage())
            );
        }
    }

    private QueryHandler findHandlerOrThrow(Query Query) {
        return this.handlers.stream()
                .filter(h -> h.canHandle(Query))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        String.format("not found supported handlers to Query: %s", getQueryName(Query)))
                );
    }

    private String getQueryName(Query Query) {
        return Query.getClass().getName();
    }
}
