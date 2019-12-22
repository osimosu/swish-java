package com.osimosu.jswish.exception;

public class ResultException extends SwishException {
    private Integer statusCode;

    public ResultException(Integer statusCode, Throwable cause) {
        super(cause);
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
