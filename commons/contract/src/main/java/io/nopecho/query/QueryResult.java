package io.nopecho.query;

import io.nopecho.utils.SelfValidator;

public interface QueryResult<SUCCESS, FAIL> extends SelfValidator {
    SUCCESS onSuccess();

    FAIL onFail();
}
