package com.osimosu.jswish.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

@ConfigurationProperties(prefix = "swish")
public class SwishProperties {
    private Resource certFile;
    private String certPassword;
    private String paymentsEndpoint;
    private String refundsEndpoint;

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

    public String getPaymentsEndpoint() {
        return paymentsEndpoint;
    }

    public void setPaymentsEndpoint(String paymentsEndpoint) {
        this.paymentsEndpoint = paymentsEndpoint;
    }

    public String getRefundsEndpoint() {
        return refundsEndpoint;
    }

    public void setRefundsEndpoint(String refundsEndpoint) {
        this.refundsEndpoint = refundsEndpoint;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "SwishProperties{" +
                "certFile=" + certFile +
                ", certPassword='" + certPassword + '\'' +
                ", paymentsEndpoint='" + paymentsEndpoint + '\'' +
                ", refundsEndpoint='" + refundsEndpoint + '\'' +
                '}';
    }
}
