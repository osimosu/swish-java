package com.osimosu.jswish.domain;

public class RefundRequest {
    private String payerPaymentReference;
    private String originalPaymentReference;
    private String callbackUrl;
    private String payerAlias;
    private String payeeAlias;
    private String amount;
    private String currency;
    private String message;

    public String getPayerPaymentReference() {
        return payerPaymentReference;
    }

    public void setPayerPaymentReference(String payerPaymentReference) {
        this.payerPaymentReference = payerPaymentReference;
    }

    public String getOriginalPaymentReference() {
        return originalPaymentReference;
    }

    public void setOriginalPaymentReference(String originalPaymentReference) {
        this.originalPaymentReference = originalPaymentReference;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getPayerAlias() {
        return payerAlias;
    }

    public void setPayerAlias(String payerAlias) {
        this.payerAlias = payerAlias;
    }

    public String getPayeeAlias() {
        return payeeAlias;
    }

    public void setPayeeAlias(String payeeAlias) {
        this.payeeAlias = payeeAlias;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public RefundRequest payerPaymentReference(String payerPaymentReference) {
        this.payerPaymentReference = payerPaymentReference;
        return this;
    }

    public RefundRequest originalPaymentReference(String originalPaymentReference) {
        this.originalPaymentReference = originalPaymentReference;
        return this;
    }

    public RefundRequest callbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public RefundRequest payerAlias(String payerAlias) {
        this.payerAlias = payerAlias;
        return this;
    }

    public RefundRequest payeeAlias(String payeeAlias) {
        this.payeeAlias = payeeAlias;
        return this;
    }

    public RefundRequest amount(String amount) {
        this.amount = amount;
        return this;
    }

    public RefundRequest currency(String currency) {
        this.currency = currency;
        return this;
    }

    public RefundRequest message(String message) {
        this.message = message;
        return this;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "RefundRequest{" +
                "payerPaymentReference='" + payerPaymentReference + '\'' +
                ", originalPaymentReference='" + originalPaymentReference + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", payerAlias='" + payerAlias + '\'' +
                ", payeeAlias='" + payeeAlias + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
