package com.guoxuezhishi.pojo.yunzhongxin;

import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/9/9
 */
@ApiModel(value = "车牌付扣款",description = "车牌付扣款")
public class LicensePlatePayBO extends BaseBO {
    @ApiModelProperty(value = "", name = "", example = "LicensePlatePay", required = true)
    private String service;
    @ApiModelProperty(value = "", name = "", example = "京DJK876", required = true)
    private String plateNo;
    @ApiModelProperty(value = "", name = "", example = "0", required = true)
    private String plateColorCode;
    @ApiModelProperty(value = "", name = "", example = "0", required = true)
    private String vehTypeCode;
    @ApiModelProperty(value = "", name = "", example = "1", required = true)
    private String payScene;
    @ApiModelProperty(value = "", name = "", example = "CNY", required = true)
    private String ccy;
    @ApiModelProperty(value = "", name = "", example = "1", required = true,notes = "订单金额，以分为单位")
    private String orderAmount;
    @ApiModelProperty(value = "", name = "", example = "车牌付扣款", required = true)
    private String orderDesc;
    @ApiModelProperty(value = "", name = "", example = "车牌付扣款", required = true)
    private String remark;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getPlateColorCode() {
        return plateColorCode;
    }

    public void setPlateColorCode(String plateColorCode) {
        this.plateColorCode = plateColorCode;
    }

    public String getVehTypeCode() {
        return vehTypeCode;
    }

    public void setVehTypeCode(String vehTypeCode) {
        this.vehTypeCode = vehTypeCode;
    }

    public String getPayScene() {
        return payScene;
    }

    public void setPayScene(String payScene) {
        this.payScene = payScene;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
