package com.guoxuezhishi.pojo.eaccount;

import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/7/1
 */
public class EAccountCheckBO extends BaseBO {
    @ApiModelProperty(value = "", name = "", example = "1.0", required = true)
    private String version;
    @ApiModelProperty(value = "", name = "", example = "20190610100000", required = true)
    private String requestTime;
    @ApiModelProperty(value = "", name = "", example = "icbc", required = true)
    private String bussId;
    @ApiModelProperty(value = "", name = "", example = "955888", required = true)
    private String smsCode;
    @ApiModelProperty(value = "", name = "", example = "185187", required = true)
    private String smsNumber;
    @ApiModelProperty(value = "", name = "", example = "20190801100021098110", required = true)
    private String orderNo;
    @ApiModelProperty(value = "", name = "", example = "0", required = true)
    private String type;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getBussId() {
        return bussId;
    }

    public void setBussId(String bussId) {
        this.bussId = bussId;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getSmsNumber() {
        return smsNumber;
    }

    public void setSmsNumber(String smsNumber) {
        this.smsNumber = smsNumber;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}