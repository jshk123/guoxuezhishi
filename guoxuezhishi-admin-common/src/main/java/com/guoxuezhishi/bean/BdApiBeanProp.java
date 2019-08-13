package com.guoxuezhishi.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: jiang
 * @date: 2019/7/29
 */
@Component
@ConfigurationProperties(prefix = "bd")
@PropertySource("bdapi.properties")
public class BdApiBeanProp {
    private String appIdYysb;
    private String apiKeyYysb;
    private String secretKeyYysb;
    private String appIdRlsb;
    private String apiKeyRlsb;
    private String secretKeyRlsb;

    public String getAppIdYysb() {
        return appIdYysb;
    }

    public void setAppIdYysb(String appIdYysb) {
        this.appIdYysb = appIdYysb;
    }

    public String getApiKeyYysb() {
        return apiKeyYysb;
    }

    public void setApiKeyYysb(String apiKeyYysb) {
        this.apiKeyYysb = apiKeyYysb;
    }

    public String getSecretKeyYysb() {
        return secretKeyYysb;
    }

    public void setSecretKeyYysb(String secretKeyYysb) {
        this.secretKeyYysb = secretKeyYysb;
    }

    public String getAppIdRlsb() {
        return appIdRlsb;
    }

    public void setAppIdRlsb(String appIdRlsb) {
        this.appIdRlsb = appIdRlsb;
    }

    public String getApiKeyRlsb() {
        return apiKeyRlsb;
    }

    public void setApiKeyRlsb(String apiKeyRlsb) {
        this.apiKeyRlsb = apiKeyRlsb;
    }

    public String getSecretKeyRlsb() {
        return secretKeyRlsb;
    }

    public void setSecretKeyRlsb(String secretKeyRlsb) {
        this.secretKeyRlsb = secretKeyRlsb;
    }
}
