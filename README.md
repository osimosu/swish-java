# jswish

Java Spring library for the [Swish](https://www.getswish.se/) API.

## Requirements

Java 1.8 or later.

## Installation

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.osimosu</groupId>
  <artifactId>jswish</artifactId>
  <version>0.0.1</version>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
implementation "com.osimosu:jswish:0.0.1"
```

## Usage


application.yml

```yaml
swish:
  payments-endpoint: https://mss.cpc.getswish.net/swish-cpcapi/api/v1/paymentrequests/
  refunds-endpoint: https://mss.cpc.getswish.net/swish-cpcapi/api/v1/refunds/
  cert-file: classpath:swish/Swish_Merchant_TestCertificate_1231181189.p12
  cert-password: swish
```

DemoAppConfig.java
```java
package com.example.demo.config;

import com.osimosu.jswish.config.SwishConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SwishConfig.class)
public class DemoAppConfig {
}

```


DemoApplication.java

```java
package com.example.demo;

import com.osimosu.jswish.domain.Payment;
import com.osimosu.jswish.domain.PaymentRequest;
import com.osimosu.jswish.exception.SwishException;
import com.osimosu.jswish.exception.payment.PaymentRequestException;
import com.osimosu.jswish.exception.payment.PaymentResultException;
import com.osimosu.jswish.service.SwishService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(SwishService swishService) {
        return args -> {

            PaymentRequest paymentRequest = new PaymentRequest()
                    .amount("100")
                    .currency("SEK")
                    .payeeAlias("1231181189")
                    .payerAlias("46733854950")
                    .payeePaymentReference("1")
                    .message("iPhone 6s")
                    .callbackUrl("https://myfakehost.se/swishcallback.cfm"); // callbackUrl is called by MSS with payment result

            try {
                // Create a payment
                String paymentRequestToken = swishService.createPayment(paymentRequest);

                // Wait for approval by swish user
                TimeUnit.SECONDS.sleep(5);

                // Retrieve payment result with token manually
                Payment payment = swishService.getPayment(paymentRequestToken);
                System.out.println(payment);

            } catch (PaymentRequestException e) {
                // Retrieve status code and list of errors
            } catch (PaymentResultException e) {
                // Retrieve status code
            } catch (SwishException e) {
                // Random error
            }
        };
    }
}
```

## License

See the [LICENSE](LICENSE.md) file for license rights and limitations (MIT).
