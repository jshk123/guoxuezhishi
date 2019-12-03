package com.guoxuezhishi.pojo.yunzhongxinxiangguan;

import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/11/28
 */
@ApiModel(value = "PSAM卡签到", description = "PSAM卡签到")
public class SignApplyBO extends BaseBO {
    @ApiModelProperty(value = "", name = "", example = "SignApply", required = true, dataType = "String")
    private String service;
    @ApiModelProperty(value = "", name = "", example = "", required = false, dataType = "String")
    private String subMerchantId;
    @ApiModelProperty(value = "", name = "", example = "22222222222222222222", required = true, dataType = "String")
    private String psamNo;
    @ApiModelProperty(value = "", name = "", example = "123456", required = true, dataType = "String")
    private String terminalNo;
    @ApiModelProperty(value = "", name = "", example = "2019-11-28 14:09:30", required = true, dataType = "String")
    private String terminalTime;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getSubMerchantId() {
        return subMerchantId;
    }

    public void setSubMerchantId(String subMerchantId) {
        this.subMerchantId = subMerchantId;
    }

    public String getPsamNo() {
        return psamNo;
    }

    public void setPsamNo(String psamNo) {
        this.psamNo = psamNo;
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }

    public String getTerminalTime() {
        return terminalTime;
    }

    public void setTerminalTime(String terminalTime) {
        this.terminalTime = terminalTime;
    }
}

