package com.guoxuezhishi.pojo.yunzhongxinxiangguan;

import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/11/28
 */
@ApiModel(value = "PSAM卡授权确认", description = "PSAM卡授权确认")
public class AuthConfirmBO extends BaseBO {
    @ApiModelProperty(value = "", name = "", example = "AuthConfirm", required = true, dataType = "String")
    private String service;
    @ApiModelProperty(value = "", name = "", example = "", required = false, dataType = "String")
    private String subMerchantId;
    @ApiModelProperty(value = "", name = "", example = "22222222222222222222", required = true, dataType = "String")
    private String psamNo;
    @ApiModelProperty(value = "", name = "", example = "0001", required = true, dataType = "String")
    private String listNo;
    @ApiModelProperty(value = "", name = "", example = "成功", required = true, dataType = "String")
    private String result;
    @ApiModelProperty(value = "", name = "", example = "00", required = true, dataType = "String")
    private String resultCode;

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

    public String getListNo() {
        return listNo;
    }

    public void setListNo(String listNo) {
        this.listNo = listNo;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
}
