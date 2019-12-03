package com.guoxuezhishi.pojo.yunzhongxinxiangguan;

import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/11/28
 */
@ApiModel(value = "PSAM卡授权申请", description = "PSAM卡授权申请")
public class AuthApplyBO extends BaseBO {
    @ApiModelProperty(value = "", name = "", example = "AuthApply", required = true, dataType = "String")
    private String service;
    @ApiModelProperty(value = "", name = "", example = "", required = false, dataType = "String")
    private String subMerchantId;
    @ApiModelProperty(value = "", name = "", example = "22222222222222222222", required = true, dataType = "String")
    private String psamNo;
    @ApiModelProperty(value = "", name = "", example = "1.0.0", required = true, dataType = "String")
    private String psamVersion;
    @ApiModelProperty(value = "", name = "", example = "01234567890123456789000000000000", required = true, dataType = "String")
    private String random;
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

    public String getPsamVersion() {
        return psamVersion;
    }

    public void setPsamVersion(String psamVersion) {
        this.psamVersion = psamVersion;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    public String getTerminalTime() {
        return terminalTime;
    }

    public void setTerminalTime(String terminalTime) {
        this.terminalTime = terminalTime;
    }
}
