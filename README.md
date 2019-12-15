# jswish

Java library for the Stripe API.

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
  payment-requests-endpoint: https://mss.cpc.getswish.net/swish-cpcapi/api/v1/paymentrequests
  cert-file: classpath:swish/Swish_Merchant_TestCertificate_1231181189.p12
  cert-password: swish
```

MyAppSwishConfig.java
```java
import com.osimosu.jswish.config.SwishConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SwishConfig.class)
public class MyAppSwishConfig {
}
```


SwishExample.java

```java
import com.osimosu.jswish.domain.PaymentRequest;
import com.osimosu.jswish.exceptions.SwishException;
import com.osimosu.jswish.service.SwishService;

public class SwishExample {

    public static void main(String[] args) {
		
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
		} catch (SwishException e) {
			e.printStackTrace();
		}
    }
}
```

## License

See the [LICENSE](LICENSE.md) file for license rights and limitations (MIT).
