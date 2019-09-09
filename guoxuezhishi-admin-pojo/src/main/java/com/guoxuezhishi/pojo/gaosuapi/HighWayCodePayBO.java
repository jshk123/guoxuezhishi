package com.guoxuezhishi.pojo.gaosuapi;

import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/9/9
 */
@ApiModel(value = "高速扣费", description = "高速扣费")
public class HighWayCodePayBO extends BaseBO {
    @ApiModelProperty(value = "", name = "", example = "134600000000000000", required = true)
    private String authCode;
    @ApiModelProperty(value = "", name = "", example = "1", required = true)
    private String orderAmt;

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(String orderAmt) {
        this.orderAmt = orderAmt;
    }
}
