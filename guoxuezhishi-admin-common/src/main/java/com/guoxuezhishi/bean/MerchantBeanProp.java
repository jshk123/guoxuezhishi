package com.guoxuezhishi.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: jiang
 * @date: 2019/7/3
 */
@Component
@ConfigurationProperties(prefix = "sdk")
@PropertySource(value = "merchant.properties")
public class MerchantBeanProp {
    private String requestUrl;
    private String offlineNotifyUrl;
    private String pageReturnUrl;
    private String merchantId;
    private String merchantName;
    private String signType;
    private String version;
    private String merchantCertPath;
    private String merchantCertPass;
    private String rootCertPath;
    private String charset;
    private String checkFileDir;

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getOfflineNotifyUrl() {
        return offlineNotifyUrl;
    }

    public void setOfflineNotifyUrl(String offlineNotifyUrl) {
        this.offlineNotifyUrl = offlineNotifyUrl;
    }

    public String getPageReturnUrl() {
        return pageReturnUrl;
    }

    public void setPageReturnUrl(String pageReturnUrl) {
        this.pageReturnUrl = pageReturnUrl;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMerchantCertPath() {
        return merchantCertPath;
    }

    public void setMerchantCertPath(String merchantCertPath) {
        this.merchantCertPath = merchantCertPath;
    }

    public String getMerchantCertPass() {
        return merchantCertPass;
    }

    public void setMerchantCertPass(String merchantCertPass) {
        this.merchantCertPass = merchantCertPass;
    }

    public String getRootCertPath() {
        return rootCertPath;
    }

    public void setRootCertPath(String rootCertPath) {
        this.rootCertPath = rootCertPath;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getCheckFileDir() {
        return checkFileDir;
    }

    public void setCheckFileDir(String checkFileDir) {
        this.checkFileDir = checkFileDir;
    }
}
