package com.osimosu.jswish.domain;

import java.math.BigDecimal;

public class Refund {
    private String id;
    private String paymentReference;
    private String payerPaymentReference;
    private String originalPaymentReference;
    private String callbackUrl;
    private String payerAlias;
    private String payeeAlias;
    private BigDecimal amount;
    private String currency;
    private String message;
    private String status;
    private String dateCreated;
    private String datePaid;
    private String errorMessage;
    private String additionalInformation;
    private String errorCode;

    public String getId() {
        return id;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public String getPayerPaymentReference() {
        return payerPaymentReference;
    }

    public String getOriginalPaymentReference() {
        return originalPaymentReference;
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

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public void setPayerPaymentReference(String payerPaymentReference) {
        this.payerPaymentReference = payerPaymentReference;
    }

    public void setOriginalPaymentReference(String originalPaymentReference) {
        this.originalPaymentReference = originalPaymentReference;
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

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "Refund{" +
                "id='" + id + '\'' +
                ", paymentReference='" + paymentReference + '\'' +
                ", payerPaymentReference='" + payerPaymentReference + '\'' +
                ", originalPaymentReference='" + originalPaymentReference + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", payerAlias='" + payerAlias + '\'' +
                ", payeeAlias='" + payeeAlias + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", datePaid='" + datePaid + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", additionalInformation='" + additionalInformation + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }
}
