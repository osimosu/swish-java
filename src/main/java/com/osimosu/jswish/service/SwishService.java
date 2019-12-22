package com.osimosu.jswish.service;

import com.osimosu.jswish.domain.Payment;
import com.osimosu.jswish.domain.PaymentRequest;
import com.osimosu.jswish.domain.Refund;
import com.osimosu.jswish.domain.RefundRequest;
import com.osimosu.jswish.exception.SwishException;
import com.osimosu.jswish.exception.payment.PaymentRequestException;

public interface SwishService {
    String createPayment(PaymentRequest paymentRequest) throws SwishException, PaymentRequestException;

    Payment getPayment(String paymentRequestToken) throws SwishException;

    String createRefund(RefundRequest refundRequest) throws SwishException;

    Refund getRefund(String refundRequestToken) throws SwishException;
}