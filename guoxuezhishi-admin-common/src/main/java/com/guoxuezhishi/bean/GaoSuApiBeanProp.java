package com.guoxuezhishi.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: jiang
 * @date: 2019/9/9
 */
@Component
@ConfigurationProperties(prefix = "gaosu")
@PropertySource("gaosuapi.properties")
public class GaoSuApiBeanProp {
    /**
     * 获取设备秘钥信息
     */
    private String getSm4Secret;
    /**
     * 支付请求交易
     */
    private String highwayCodePay;
    /**
     * 支付结果查询
     */
    private String highOrderPaySearch;
    /**
     * 支付退款申请
     */
    private String highRefundApply;
    /**
     * 退款结果查询
     */
    private String highOrderRefundSearch;
    /**
     * 撤销申请
     */
    private String highOrderReverse;
    /**
     * 获取设备秘钥信息
     */
    private String getMercSecret;
    /**
     * 设备编号
     */
    private String deviceNo;
    /**
     * 商户SM2私钥
     */
    private String mercPrivateKey;
    /**
     * 商户SM2公钥
     */
    private String mercPublicKey;
    /**
     * 平台SM2公钥
     */
    private String platPublicKey;
    /**
     * 设备SM4加密秘钥
     */
    private String sm4Key;
    /**
     * 设备SM2私钥
     */
    private String sm2Key;
    /**
     * 设备SM2公钥
     */
    private String sm2PubKey;

    public String getGetSm4Secret() {
        return getSm4Secret;
    }

    public void setGetSm4Secret(String getSm4Secret) {
        this.getSm4Secret = getSm4Secret;
    }

    public String getHighwayCodePay() {
        return highwayCodePay;
    }

    public void setHighwayCodePay(String highwayCodePay) {
        this.highwayCodePay = highwayCodePay;
    }

    public String getHighOrderPaySearch() {
        return highOrderPaySearch;
    }

    public void setHighOrderPaySearch(String highOrderPaySearch) {
        this.highOrderPaySearch = highOrderPaySearch;
    }

    public String getHighRefundApply() {
        return highRefundApply;
    }

    public void setHighRefundApply(String highRefundApply) {
        this.highRefundApply = highRefundApply;
    }

    public String getHighOrderRefundSearch() {
        return highOrderRefundSearch;
    }

    public void setHighOrderRefundSearch(String highOrderRefundSearch) {
        this.highOrderRefundSearch = highOrderRefundSearch;
    }

    public String getHighOrderReverse() {
        return highOrderReverse;
    }

    public void setHighOrderReverse(String highOrderReverse) {
        this.highOrderReverse = highOrderReverse;
    }

    public String getGetMercSecret() {
        return getMercSecret;
    }

    public void setGetMercSecret(String getMercSecret) {
        this.getMercSecret = getMercSecret;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getMercPrivateKey() {
        return mercPrivateKey;
    }

    public void setMercPrivateKey(String mercPrivateKey) {
        this.mercPrivateKey = mercPrivateKey;
    }

    public String getMercPublicKey() {
        return mercPublicKey;
    }

    public void setMercPublicKey(String mercPublicKey) {
        this.mercPublicKey = mercPublicKey;
    }

    public String getPlatPublicKey() {
        return platPublicKey;
    }

    public void setPlatPublicKey(String platPublicKey) {
        this.platPublicKey = platPublicKey;
    }

    public String getSm4Key() {
        return sm4Key;
    }

    public void setSm4Key(String sm4Key) {
        this.sm4Key = sm4Key;
    }

    public String getSm2Key() {
        return sm2Key;
    }

    public void setSm2Key(String sm2Key) {
        this.sm2Key = sm2Key;
    }

    public String getSm2PubKey() {
        return sm2PubKey;
    }

    public void setSm2PubKey(String sm2PubKey) {
        this.sm2PubKey = sm2PubKey;
    }
}
