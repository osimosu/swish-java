package com.osimosu.jswish.exception;

public class RequestError {
    private String errorCode;
    private String errorMessage;
    private String additionalInformation;

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setErPyrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
