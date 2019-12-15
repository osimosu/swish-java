package com.osimosu.jswish;

import com.osimosu.jswish.config.SwishProperties;
import com.osimosu.jswish.domain.PaymentRequest;
import com.osimosu.jswish.exceptions.SwishException;
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


		PaymentRequest paymentRequest = new PaymentRequest()
				.amount("100")
				.currency("SEK")
				.payeeAlias("1231181189")
				.payerAlias("46733854950")
				.payeePaymentReference("1")
				.message("iPhone 6s")
				.callbackUrl("https://myfakehost.se/swishcallback.cfm");

		try {
			String location = swishService.createPayment(paymentRequest);
			Assertions.assertThat(location).isNotNull();
		} catch (SwishException e) {
			e.printStackTrace();
		}

	}

	@SpringBootApplication
	static class TestConfiguration {
	}
}
