package com.guoxuezhishi.pojo.duijieyunzhongxin;

import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/8/27
 */
@ApiModel(value = "云中心车牌发行状态查询",description = "云中心车牌发行状态查询")
public class PlatePayInfoQueryBO extends BaseBO {
    @ApiModelProperty(value = "", name = "", example = "PlatePayInfoQuery", required = true)
    private String service;
    @ApiModelProperty(value = "", name = "", example = "京NHA100", required = true)
    private String plateNo;
    @ApiModelProperty(value = "", name = "", example = "0", required = true)
    private String vehplateColor;
    @ApiModelProperty(value = "", name = "", example = "0", required = true)
    private String vehTypeCode;
    @ApiModelProperty(value = "", name = "", example = "13810035335", required = true)
    private String mblNo;
    @ApiModelProperty(value = "", name = "", example = "111111", required = true)
    private String checkNo;

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

    public String getVehplateColor() {
        return vehplateColor;
    }

    public void setVehplateColor(String vehplateColor) {
        this.vehplateColor = vehplateColor;
    }

    public String getVehTypeCode() {
        return vehTypeCode;
    }

    public void setVehTypeCode(String vehTypeCode) {
        this.vehTypeCode = vehTypeCode;
    }

    public String getMblNo() {
        return mblNo;
    }

    public void setMblNo(String mblNo) {
        this.mblNo = mblNo;
    }

    public String getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo;
    }
}
