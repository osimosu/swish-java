package com.osimosu.jswish.exception.refund;

import com.osimosu.jswish.exception.ResultException;

public class RefundResultException extends ResultException {
    public RefundResultException(Integer statusCode, Throwable cause) {
        super(statusCode, cause);
    }
}
