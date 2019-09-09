package com.guoxuezhishi.pojo.yunzhongxin;

import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/8/27
 */
@ApiModel(value = "车牌付功能是否可用",description = "车牌付功能是否可用")
public class PlatePayMethodQueryBO extends BaseBO {

    @ApiModelProperty(value = "", name = "", example = "PlatePayMethodQuery", required = true)
    private String service;
    @ApiModelProperty(value = "", name = "", example = "京NHA100", required = true)
    private String plateNo;
    @ApiModelProperty(value = "", name = "", example = "0", required = true)
    private String plateColorCode;
    @ApiModelProperty(value = "", name = "", example = "0", required = true)
    private String vehTypeCode;

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
}
