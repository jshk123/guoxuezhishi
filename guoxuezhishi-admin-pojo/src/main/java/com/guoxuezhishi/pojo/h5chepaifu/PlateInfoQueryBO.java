package com.guoxuezhishi.pojo.h5chepaifu;

import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/8/7
 */
@ApiModel(value = "查询无感支付状态", description = "查询无感支付状态")
public class PlateInfoQueryBO extends BaseBO {
    @ApiModelProperty(value = "字符集", name = "字符集", example = "00", required = true)
    private String charset;
    @ApiModelProperty(value = "", name = "", example = "1.0", required = true)
    private String version;
    @ApiModelProperty(value = "", name = "", example = "PlateInfoQuery", required = true)
    private String service;
    @ApiModelProperty(value = "", name = "", example = "20190101", required = true)
    private String requestTime;
    @ApiModelProperty(value = "", name = "", example = "京B90414", required = true)
    private String plateNo;
    @ApiModelProperty(value = "", name = "", example = "11011201220000207302", required = true)
    private String cardNo;
    @ApiModelProperty(value = "", name = "", example = "18612839458", required = true)
    private String mblNo;
    @ApiModelProperty(value = "", name = "", example = "0", required = true)
    private String vehplateColor;
    @ApiModelProperty(value = "", name = "", example = "0", required = true)
    private String vehTypeCode;
    /*    @ApiModelProperty(value = "", name = "", example = "08f2067e-4383-4ef9-ad9a-e304dae6232b", required = true)
        private String customerId;*/
    @ApiModelProperty(value = "", name = "", example = "123123", required = true)
    private String checkNo;

    public String getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo;
    }

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

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getMblNo() {
        return mblNo;
    }

    public void setMblNo(String mblNo) {
        this.mblNo = mblNo;
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

}
