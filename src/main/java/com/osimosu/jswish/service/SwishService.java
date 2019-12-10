package com.osimosu.jswish.service;

import com.osimosu.jswish.domain.Payment;
import com.osimosu.jswish.domain.PaymentRequest;
import com.osimosu.jswish.domain.RefundRequest;

public interface SwishService {
    String createPayment(PaymentRequest paymentRequest);

    Payment getPayment(String paymentRequestToken);

    String createRefund(RefundRequest refundRequest);
}