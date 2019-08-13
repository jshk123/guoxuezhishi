package com.guoxuezhishi.pojo.wxfenzhang;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/7/3
 */
public class ProfitSharingBO extends WXFenZhangBO {
    @ApiModelProperty(value = "商户号",name = "", example = "1900000100", required = true)
    private String mch_id;

    @ApiModelProperty(value = "子商户号", name = "", example = "1900000109", required = true)
    private String sub_mch_id;

    @ApiModelProperty(value = "公众账号ID", name = "", example = "wx8888888888888888", required = true)
    private String appid;

    @ApiModelProperty(value = "子商户公众账号ID", name = "", example = "wx8888888888888888", required = false)
    private String sub_appid;

    @ApiModelProperty(value = "随机字符串", name = "", example = "5K8264ILTKCH16CQ2502SI8ZNMTM67VS", required = true)
    private String nonce_str;

    @ApiModelProperty(value = "签名", name = "", example = "C380BEC2BFD727A4B6845133519F3AD6C380BEC2BFD727A4B6845133519F3AD6", required = true)
    private String sign;

    @ApiModelProperty(value = "签名类型", name = "", example = "HMAC-SHA256", required = false)
    private String sign_type;

    @ApiModelProperty(value = "微信订单号", name = "", example = "4208450740201411110007820472", required = true)
    private String transaction_id;

    @ApiModelProperty(value = "商户分账单号", name = "", example = "P20150806125346", required = true)
    private String out_order_no;

    @ApiModelProperty(value = "分账接收方列表", name = "", example = "<![CDATA[[{\"type\":\"MERCHANT_ID\",\"account\":\"190001001\",\"amount\":100,\"description\":\"分到商户\"},{\"type\":\"PERSONAL_WECHATID\",\"account\":\"86693952\",\"amount\":888,\"description\":\"分到个人\"}]", required = true)
    private String receivers;

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSub_appid() {
        return sub_appid;
    }

    public void setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_order_no() {
        return out_order_no;
    }

    public void setOut_order_no(String out_order_no) {
        this.out_order_no = out_order_no;
    }

    public String getReceivers() {
        return receivers;
    }

    public void setReceivers(String receivers) {
        this.receivers = receivers;
    }
}
