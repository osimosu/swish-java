package com.osimosu.jswish.service.impl;

import com.osimosu.jswish.config.SwishProperties;
import com.osimosu.jswish.domain.Payment;
import com.osimosu.jswish.domain.PaymentRequest;
import com.osimosu.jswish.domain.RefundRequest;
import com.osimosu.jswish.exceptions.SwishException;
import com.osimosu.jswish.service.SwishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@EnableConfigurationProperties(SwishProperties.class)
public class SwishServiceImpl implements SwishService {

    private final RestTemplate restTemplate;

    private final SwishProperties swishProperties;

    @Autowired
    public SwishServiceImpl(@Qualifier("SwishClient") RestTemplate restTemplate, SwishProperties swishProperties) {
        this.restTemplate = restTemplate;
        this.swishProperties = swishProperties;
    }

    @Override
    public String createPayment(PaymentRequest paymentRequest) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PaymentRequest> entity = new HttpEntity<>(paymentRequest, headers);

        try {
            ResponseEntity<String> responseEntity = restTemplate
                    .postForEntity(swishProperties.getPaymentRequestsEndpoint(), entity, String.class);

            return responseEntity.getHeaders().getFirst(HttpHeaders.LOCATION);

        } catch (Exception e) {
           throw new SwishException(e.getMessage());
        }
    }

    @Override
    public Payment getPayment(String paymentRequestToken) {
        return null;
    }

    @Override
    public String createRefund(RefundRequest refundRequest) {
        return null;
    }
}
