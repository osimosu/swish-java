package com.osimosu.jswish.config;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

@Configuration
@EnableConfigurationProperties(SwishProperties.class)
public class SwishClient {

    public static final String KEYSTORE_TYPE = "PKCS12";
    public static final String SSL_PROTOCOL = "TLS";

    private final SwishProperties swishProperties;

    public SwishClient(SwishProperties swishProperties) {
        this.swishProperties = swishProperties;
    }

    @Bean("SwishClient")
    public RestTemplate restTemplate() throws Exception {

        KeyStore clientStore = KeyStore.getInstance(KEYSTORE_TYPE);
        InputStream clientStoreInputStream = swishProperties.getCertFile().getInputStream();
        clientStore.load(clientStoreInputStream, swishProperties.getCertPassword().toCharArray());
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(clientStore, swishProperties.getCertPassword().toCharArray());
        KeyManager[] kms = kmf.getKeyManagers();
        SSLContext sslContext = SSLContext.getInstance(SSL_PROTOCOL);
        sslContext.init(kms, getTrustAllCerts(), new SecureRandom());

        // SSLSocketFactory
        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext);

        //HttpClient build
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).build();

        HttpComponentsClientHttpRequestFactory factory =
                new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(factory);
    }

    private TrustManager[] getTrustAllCerts() {
        return new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }

                    public void checkClientTrusted(
                            X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted(
                            X509Certificate[] certs, String authType) {
                    }
                }
        };
    }
}
