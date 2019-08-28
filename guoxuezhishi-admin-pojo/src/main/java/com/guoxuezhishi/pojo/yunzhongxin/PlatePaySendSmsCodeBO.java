package com.guoxuezhishi.pojo.yunzhongxin;

import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/8/27
 */
public class PlatePaySendSmsCodeBO extends BaseBO {
    @ApiModelProperty(value = "", name = "", example = "00", required = true)
    private String charset;
    @ApiModelProperty(value = "", name = "", example = "1.0", required = true)
    private String version;
    @ApiModelProperty(value = "", name = "", example = "RSA", required = true)
    private String signType;
    @ApiModelProperty(value = "", name = "", example = "PlatePaySendSmsCode", required = true)
    private String service;
    @ApiModelProperty(value = "", name = "", example = "京NHA100", required = true)
    private String plateNo;
    @ApiModelProperty(value = "", name = "", example = "0", required = true)
    private String vehplateColor;
    @ApiModelProperty(value = "", name = "", example = "0", required = true)
    private String vehTypeCode;
    @ApiModelProperty(value = "", name = "", example = "13810035335", required = true)
    private String mblNo;

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

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
}
