package com.osimosu.jswish.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

@ConfigurationProperties(prefix = "swish")
public class SwishProperties {
    private Resource certFile;
    private String certPassword;
    private String paymentRequestsEndpoint;

    public Resource getCertFile() {
        return certFile;
    }

    public void setCertFile(Resource certFile) {
        this.certFile = certFile;
    }

    public String getCertPassword() {
        return certPassword;
    }

    public void setCertPassword(String certPassword) {
        this.certPassword = certPassword;
    }

    public String getPaymentRequestsEndpoint() {
        return paymentRequestsEndpoint;
    }

    public void setPaymentRequestsEndpoint(String paymentRequestsEndpoint) {
        this.paymentRequestsEndpoint = paymentRequestsEndpoint;
    }
}
