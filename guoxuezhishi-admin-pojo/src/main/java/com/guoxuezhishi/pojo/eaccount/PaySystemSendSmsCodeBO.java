package com.guoxuezhishi.pojo.eaccount;

import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/9/4
 * 发送验证码
 */
public class PaySystemSendSmsCodeBO extends BaseBO {
    @ApiModelProperty(value = "", name = "", example = "15668022153", required = true)
    private String phoneNo;
    @ApiModelProperty(value = "", name = "", example = "2", required = true)
    private String bussType;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getBussType() {
        return bussType;
    }

    public void setBussType(String bussType) {
        this.bussType = bussType;
    }
}
