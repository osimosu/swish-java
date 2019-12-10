package com.osimosu.jswish.domain;

public class PaymentRequest {
    private String payeePaymentReference;
    private String callbackUrl;
    private String payerAlias;
    private String payerSSN;
    private String ageLimit;
    private String payeeAlias;
    private String amount;
    private String currency;
    private String message;

    public String getPayeePaymentReference() {
        return payeePaymentReference;
    }

    public void setPayeePaymentReference(String payeePaymentReference) {
        this.payeePaymentReference = payeePaymentReference;
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

    public String getPayerSSN() {
        return payerSSN;
    }

    public void setPayerSSN(String payerSSN) {
        this.payerSSN = payerSSN;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
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


    public PaymentRequest payeePaymentReference(String payeePaymentReference) {
        this.payeePaymentReference = payeePaymentReference;
        return this;
    }

    public PaymentRequest callbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public PaymentRequest payerAlias(String payerAlias) {
        this.payerAlias = payerAlias;
        return this;
    }

    public PaymentRequest payerSSN(String payerSSN) {
        this.payerSSN = payerSSN;
        return this;
    }

    public PaymentRequest ageLimit(String ageLimit) {
        this.ageLimit = ageLimit;
        return this;
    }

    public PaymentRequest payeeAlias(String payeeAlias) {
        this.payeeAlias = payeeAlias;
        return this;
    }

    public PaymentRequest amount(String amount) {
        this.amount = amount;
        return this;
    }

    public PaymentRequest currency(String currency) {
        this.currency = currency;
        return this;
    }

    public PaymentRequest message(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "payeePaymentReference='" + payeePaymentReference + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", payerAlias='" + payerAlias + '\'' +
                ", payerSSN='" + payerSSN + '\'' +
                ", ageLimit='" + ageLimit + '\'' +
                ", payeeAlias='" + payeeAlias + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
