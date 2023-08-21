package io.nopecho.query;

import io.nopecho.utils.SelfValidator;

public interface Query extends SelfValidator {

    boolean isType(Class<? extends Query> clazz);
}
