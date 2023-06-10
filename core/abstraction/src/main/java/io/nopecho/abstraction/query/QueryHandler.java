package io.nopecho.abstraction.query;

public interface QueryHandler {

    boolean canHandle(Query query);

    QueryResult handle(Query query);

    default <T extends Query> T tryCast(Query query, Class<T> classOfT) {
        if (canHandle(query)) {
            return classOfT.cast(query);
        }
        throw new RuntimeException(
                String.format("can not casting to query. because not handle this query: %s", query.getClass())
        );
    }
}
