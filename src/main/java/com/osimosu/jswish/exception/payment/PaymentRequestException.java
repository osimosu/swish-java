package com.osimosu.jswish.exception.payment;

import com.osimosu.jswish.exception.RequestError;
import com.osimosu.jswish.exception.RequestException;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

public class PaymentRequestException extends RequestException {

    public PaymentRequestException(List<RequestError> requestErrors, HttpStatusCodeException e) {
        super(requestErrors, e);
    }
}
