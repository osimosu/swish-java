package com.osimosu.jswish;

import com.osimosu.jswish.domain.PaymentRequest;
import com.osimosu.jswish.exception.SwishException;
import com.osimosu.jswish.service.SwishService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
public class SwishServiceTest {

    @Autowired
    private SwishService swishService;

    @Test
    public void createPayment() {

        PaymentRequest paymentRequest = new PaymentRequest()
                .amount("100")
                .currency("SEK")
                .payeeAlias("1231181189")
                .payerAlias("46733854950")
                .payeePaymentReference("1")
                .message("iPhone 6S")
                .callbackUrl("https://myfakehost.se/swishcallback.cfm");

        String paymentRequestToken = null;
        try {
            paymentRequestToken = swishService.createPayment(paymentRequest);
        } catch (SwishException e) {
            e.printStackTrace();
        }
        Assertions.assertThat(paymentRequestToken).isNotNull();
    }

    @SpringBootApplication
    static class TestConfiguration {
    }
}