package com.guoxuezhishi.pojo.yunzhongxin;

import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/7/3
 */
public class OrderPaySearchBO extends BaseBO {
    @ApiModelProperty(value = "", name = "", example = "00", required = true)
    private String charset;
    @ApiModelProperty(value = "", name = "", example = "1.0", required = true)
    private String version;
    @ApiModelProperty(value = "", name = "", example = "RSA", required = true)
    private String signType;
    @ApiModelProperty(value = "", name = "", example = "OrderPaySearch", required = true)
    private String service;
    @ApiModelProperty(value = "", name = "", example = "20190703121212", required = true)
    private String requestTime;
    @ApiModelProperty(value = "", name = "", example = "0", required = true)
    private String channelType;
    @ApiModelProperty(value = "", name = "", example = "02", required = true)
    private String txnType;
    @ApiModelProperty(value = "", name = "", example = "02", required = true)
    private String busType;
    @ApiModelProperty(value = "", name = "", example = "1020190604151339", required = true)
    private String orderNo;
    @ApiModelProperty(value = "", name = "", example = "支付结果查询", required = true)
    private String rmk;

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

}
