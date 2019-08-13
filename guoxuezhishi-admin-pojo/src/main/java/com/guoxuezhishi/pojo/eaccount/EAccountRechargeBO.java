package com.guoxuezhishi.pojo.eaccount;

import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/7/1
 */
public class EAccountRechargeBO extends BaseBO {
    @ApiModelProperty(value = "", name = "", example = "1.0", required = true)
    private String version;
    @ApiModelProperty(value = "", name = "", example = "20190625100000", required = true)
    private String requestTime;
    @ApiModelProperty(value = "", name = "", example = "icbc", required = true)
    private String bussId;
    @ApiModelProperty(value = "", name = "", example = "522019062515000040", required = true)
    private String outOrderNo;
    @ApiModelProperty(value = "", name = "", example = "0", required = true)
    private String flag;
    @ApiModelProperty(value = "", name = "", example = "6214760200606476205", required = true)
    private String sCardNo;
    @ApiModelProperty(value = "", name = "", example = "1111", required = true)
    private String amount;


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

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getsCardNo() {
        return sCardNo;
    }

    public void setsCardNo(String sCardNo) {
        this.sCardNo = sCardNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


}
