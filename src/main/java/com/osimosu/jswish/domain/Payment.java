package com.osimosu.jswish.domain;

import java.math.BigDecimal;

public class Payment {
    private String id;
    private String payeePaymentReference;
    private String paymentReference;
    private String callbackUrl;
    private String payerAlias;
    private String payeeAlias;
    private BigDecimal amount;
    private String currency;
    private String message;
    private String status;
    private String dateCreated;
    private String datePaid;
    private String errorCode = null;
    private String errorMessage = null;

    public String getId() {
        return id;
    }

    public String getPayeePaymentReference() {
        return payeePaymentReference;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public String getPayerAlias() {
        return payerAlias;
    }

    public String getPayeeAlias() {
        return payeeAlias;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getDatePaid() {
        return datePaid;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPayeePaymentReference(String payeePaymentReference) {
        this.payeePaymentReference = payeePaymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public void setPayerAlias(String payerAlias) {
        this.payerAlias = payerAlias;
    }

    public void setPayeeAlias(String payeeAlias) {
        this.payeeAlias = payeeAlias;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDatePaid(String datePaid) {
        this.datePaid = datePaid;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", payeePaymentReference='" + payeePaymentReference + '\'' +
                ", paymentReference='" + paymentReference + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", payerAlias='" + payerAlias + '\'' +
                ", payeeAlias='" + payeeAlias + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", datePaid='" + datePaid + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}