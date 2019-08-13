package com.guoxuezhishi.pojo.eaccount;

import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/7/1
 */
public class EAccountWithdrawBO extends BaseBO {
    @ApiModelProperty(value = "", name = "", example = "1.0", required = true)
    private String version;
    @ApiModelProperty(value = "", name = "", example = "20190610100000", required = true)
    private String requestTime;
    @ApiModelProperty(value = "", name = "", example = "icbc", required = true)
    private String bussId;
    @ApiModelProperty(value = "", name = "", example = "522019062414000040", required = true)
    private String outOrderNo;


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


}
