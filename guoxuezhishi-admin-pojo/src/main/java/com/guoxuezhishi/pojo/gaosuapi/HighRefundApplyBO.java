package com.guoxuezhishi.pojo.gaosuapi;

import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/9/9
 */
@ApiModel(value = "高速扣费退款", description = "高速扣费退款")
public class HighRefundApplyBO extends BaseBO {
    @ApiModelProperty(value = "", name = "", example = "20190101121212", required = true)
    private String orderNo;
    @ApiModelProperty(value = "", name = "", example = "1", required = true)
    private String orderAmt;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(String orderAmt) {
        this.orderAmt = orderAmt;
    }
}
