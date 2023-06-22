package io.nopecho.abstraction.query;

import io.nopecho.utils.SelfValidator;

public interface Query extends SelfValidator {

    boolean isType(Class<? extends Query> clazz);
}
