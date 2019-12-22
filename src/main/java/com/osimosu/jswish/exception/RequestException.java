package com.osimosu.jswish.exception;

import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

public class RequestException extends SwishException {

    private Integer statusCode;
    private List<RequestError> requestErrors;

    public RequestException(List<RequestError> requestErrors, HttpStatusCodeException e) {
        super(e);
        this.statusCode = e.getStatusCode().value();
        this.requestErrors = requestErrors;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public List<RequestError> getRequestErrors() {
        return requestErrors;
    }

    public void setRequestErrors(List<RequestError> requestErrors) {
        this.requestErrors = requestErrors;
    }
}
