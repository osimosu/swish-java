package com.osimosu.jswish.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.osimosu.jswish.config.SwishProperties;
import com.osimosu.jswish.domain.Payment;
import com.osimosu.jswish.domain.PaymentRequest;
import com.osimosu.jswish.domain.Refund;
import com.osimosu.jswish.domain.RefundRequest;
import com.osimosu.jswish.exception.RequestError;
import com.osimosu.jswish.exception.SwishException;
import com.osimosu.jswish.exception.payment.PaymentRequestException;
import com.osimosu.jswish.exception.payment.PaymentResultException;
import com.osimosu.jswish.exception.refund.RefundResultException;
import com.osimosu.jswish.service.SwishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.List;

@Service
@EnableConfigurationProperties(SwishProperties.class)
public class SwishServiceImpl implements SwishService {

    private final RestTemplate restTemplate;

    private final SwishProperties swishProperties;

    private final ObjectMapper mapper;

    @Autowired
    public SwishServiceImpl(@Qualifier("SwishClient") RestTemplate restTemplate, SwishProperties swishProperties, ObjectMapper mapper) {
        this.restTemplate = restTemplate;
        this.swishProperties = swishProperties;
        this.mapper = mapper;
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
            String[] split = location.split(File.separator);
            return split[split.length - 1];
        } catch (HttpStatusCodeException e) {
            List<RequestError> paymentRequestErrors = null;
            try {
                paymentRequestErrors = mapper.
                        readValue(e.getResponseBodyAsString(), mapper.getTypeFactory()
                                .constructCollectionType(List.class, RequestError.class));
            } catch (JsonProcessingException e1) {
                throw new SwishException(e1);
            }
            throw new PaymentRequestException(paymentRequestErrors, e);
        } catch (Exception e) {
            throw new SwishException(e);
        }
    }

    @Override
    public Payment getPayment(String paymentRequestToken) throws SwishException {

        try {
            return restTemplate
                    .getForObject(swishProperties.getPaymentsEndpoint() + paymentRequestToken, Payment.class);

        } catch (HttpStatusCodeException e) {
            throw new PaymentResultException(e.getStatusCode().value(), e);
        } catch (Exception e) {
            throw new SwishException(e);
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
            String[] split = location.split(File.separator);
            return split[split.length - 1];
        } catch (HttpStatusCodeException e) {
            List<RequestError> refundRequestErrors = null;
            try {
                refundRequestErrors = mapper.
                        readValue(e.getResponseBodyAsString(), mapper.getTypeFactory()
                                .constructCollectionType(List.class, RequestError.class));
            } catch (JsonProcessingException e1) {
                throw new SwishException(e1);
            }
            throw new PaymentRequestException(refundRequestErrors, e);
        } catch (Exception e) {
            throw new SwishException(e);
        }
    }

    @Override
    public Refund getRefund(String refundRequestToken) throws SwishException {
        try {
            return restTemplate
                    .getForObject(swishProperties.getRefundsEndpoint() + refundRequestToken, Refund.class);

        } catch (HttpStatusCodeException e) {
            throw new RefundResultException(e.getStatusCode().value(), e);
        } catch (Exception e) {
            throw new SwishException(e);
        }
    }
}