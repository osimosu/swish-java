# jswish

Java Spring library for the [Swish](https://www.getswish.se/) API.

## Requirements

Java 1.8 or later.

## Installation

### Maven users

Maven artifacts for this project are published to GitHub Package Registry for convenience.

Unfortunately, there is [no support for anonymous access to packages yet](https://github.community/t5/GitHub-Actions/docker-pull-from-public-GitHub-Package-Registry-fail-with-quot/td-p/32782) regardless of if the package is private or public, so you need to authenticate to GitHub Packages before you can download dependencies. 

* [Authenticate to GitHub Packages](https://help.github.com/en/github/managing-packages-with-github-packages/configuring-apache-maven-for-use-with-github-packages#authenticating-to-github-packages).

* Add this dependency to your project's POM:
```xml
<dependency>
  <groupId>com.osimosu</groupId>
  <artifactId>jswish</artifactId>
  <version>0.0.1</version>
</dependency>
```

### Others

[Download the jar](https://github.com/eosimosu/jswish/packages/92349) and install it manually.

## Usage

You need to [obtain a client certificate](https://www.swish.nu/developer#swish-for-merchants) for authentication of TLS communication with the Swish Commerce API, or you can use the certificate provided for testing.

Specify the certificate details in application properties:

application.yml

```yaml
swish:
  payments-endpoint: https://mss.cpc.getswish.net/swish-cpcapi/api/v1/paymentrequests/
  refunds-endpoint: https://mss.cpc.getswish.net/swish-cpcapi/api/v1/refunds/
  cert-file: classpath:swish/Swish_Merchant_TestCertificate_1231181189.p12
  cert-password: swish
```

Import configuration class to enable component scanning of library components:

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
                    .message("iPhone 6s Purchase")
                    .callbackUrl("https://myfakehost.se/swishcallback.cfm"); // callbackUrl is called by MSS with payment result

            try {
                // Create a payment
                String paymentRequestToken = swishService.createPayment(paymentRequest);

                // Wait for approval by swish user
                TimeUnit.SECONDS.sleep(5);

                // Optionally, manually retrieve payment result using token
                Payment payment = swishService.getPayment(paymentRequestToken);
                System.out.println(payment);

            } catch (PaymentRequestException e) {
                // Provides status code, list of errors etc
            } catch (PaymentResultException e) {
                // Provides status code
            } catch (SwishException e) {
                // Other errors
            }
        };
    }
}
```

## License

See the [LICENSE](LICENSE.md) file for license rights and limitations (MIT).
