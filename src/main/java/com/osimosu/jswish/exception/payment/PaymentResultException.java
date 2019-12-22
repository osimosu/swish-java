package com.osimosu.jswish.exception.payment;

import com.osimosu.jswish.exception.ResultException;

public class PaymentResultException extends ResultException {
    public PaymentResultException(Integer statusCode, Throwable cause) {
        super(statusCode, cause);
    }
}
