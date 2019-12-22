package com.osimosu.jswish.exception.refund;

import com.osimosu.jswish.exception.RequestError;
import com.osimosu.jswish.exception.RequestException;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

public class RefundRequestException extends RequestException {

    public RefundRequestException(List<RequestError> requestErrors, HttpStatusCodeException e) {
        super(requestErrors, e);
    }
}
