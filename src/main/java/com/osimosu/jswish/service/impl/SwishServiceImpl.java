package com.osimosu.jswish.service.impl;

import com.osimosu.jswish.config.SwishProperties;
import com.osimosu.jswish.domain.Payment;
import com.osimosu.jswish.domain.PaymentRequest;
import com.osimosu.jswish.domain.Refund;
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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.File;

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
    public String createPayment(PaymentRequest paymentRequest) throws SwishException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PaymentRequest> entity = new HttpEntity<>(paymentRequest, headers);

        try {
            ResponseEntity<String> responseEntity = restTemplate
                    .postForEntity(swishProperties.getPaymentsEndpoint(), entity, String.class);

            String location = responseEntity.getHeaders().getFirst(HttpHeaders.LOCATION);
            String[] split;
            if (location != null) {
                split = location.split(File.separator);
                return split[split.length - 1];
            }
        } catch (HttpClientErrorException e) {
            throw new SwishException(e.getMessage());
        }
        return null;
    }

    @Override
    public Payment getPayment(String paymentRequestToken) throws SwishException {

        try {
            return restTemplate
                    .getForObject(swishProperties.getPaymentsEndpoint() + paymentRequestToken, Payment.class);

        } catch (Exception e) {
            throw new SwishException(e.getMessage());
        }
    }

    @Override
    public String createRefund(RefundRequest refundRequest) throws SwishException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RefundRequest> entity = new HttpEntity<>(refundRequest, headers);

        try {
            ResponseEntity<String> responseEntity = restTemplate
                    .postForEntity(swishProperties.getRefundsEndpoint(), entity, String.class);

            String location = responseEntity.getHeaders().getFirst(HttpHeaders.LOCATION);
            String[] split;
            if (location != null) {
                split = location.split(File.separator);
                return split[split.length - 1];
            }
        } catch (HttpClientErrorException e) {
            throw new SwishException(e.getMessage());
        }
        return null;
    }

    @Override
    public Refund getRefund(String refundRequestToken) throws SwishException {
        try {
            return restTemplate
                    .getForObject(swishProperties.getRefundsEndpoint() + refundRequestToken, Refund.class);

        } catch (Exception e) {
            throw new SwishException(e.getMessage());
        }
    }
}