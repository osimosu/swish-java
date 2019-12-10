package com.osimosu.jswish;

import com.osimosu.jswish.config.SwishProperties;
import com.osimosu.jswish.domain.PaymentRequest;
import com.osimosu.jswish.service.SwishService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest()
public class SwishServiceTest {

	@Autowired
	private SwishService swishService;

	@Autowired
	private SwishProperties swishProperties;

	@Test
	public void contextLoads() throws IOException {

		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setAmount("100");
		paymentRequest.setCallbackUrl("https://myfakehost.se/swishcallback.cfm");
		paymentRequest.setCurrency("SEK");
		paymentRequest.setPayeeAlias("1231181189");
		paymentRequest.setMessage("iPhone 6S");

		String location = swishService.createPayment(paymentRequest);

		Assertions.assertThat(location).isNotNull();
	}

	@SpringBootApplication
	static class TestConfiguration {
	}
}
