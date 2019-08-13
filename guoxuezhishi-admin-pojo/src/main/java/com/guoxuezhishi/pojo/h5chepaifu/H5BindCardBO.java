package com.guoxuezhishi.pojo.h5chepaifu;

import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/7/2
 */
@ApiModel(value = "车牌付代付绑卡", description = "车牌付代付绑卡")
public class H5BindCardBO extends BaseBO {
    @ApiModelProperty(value = "", name = "", example = "e582f174-ef4d-427e-b8bf-fefb7de626ac", required = true)
    private String customerId;
    @ApiModelProperty(value = "", name = "", example = "全渠道", required = true)
    private String name;
    @ApiModelProperty(value = "", name = "", example = "6216261000000000018", required = true)
    private String cardNo;
    @ApiModelProperty(value = "", name = "", example = "", required = false)
    private String accType;
    @ApiModelProperty(value = "", name = "", example = "PABC", required = true)
    private String capCorg;
    @ApiModelProperty(value = "", name = "", example = "01", required = true)
    private String idType;
    @ApiModelProperty(value = "", name = "", example = "341126197709218366", required = true)
    private String idNo;
    @ApiModelProperty(value = "", name = "", example = "", required = false)
    private String cvn2;
    @ApiModelProperty(value = "", name = "", example = "", required = false)
    private String expDate;
    @ApiModelProperty(value = "", name = "", example = "13552535506", required = true)
    private String mblNo;
    @ApiModelProperty(value = "", name = "", example = "", required = false)
    private String smsCode;
    @ApiModelProperty(value = "", name = "", example = "", required = false)
    private String plateNo;
    @ApiModelProperty(value = "", name = "", example = "", required = false)
    private String vehplateColor;
    @ApiModelProperty(value = "", name = "", example = "", required = false)
    private String vehTypeCode;
    @ApiModelProperty(value = "获取验证码返回", name = "", example = "", required = false)
    private String token;
    @ApiModelProperty(value = "", name = "", example = "13552535506", required = false)
    private String h5MblNo;
    @ApiModelProperty(value = "0验证码；1H5；2乐速通", name = "", example = "0", required = true)
    private String reqType;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getH5MblNo() {
        return h5MblNo;
    }

    public void setH5MblNo(String h5MblNo) {
        this.h5MblNo = h5MblNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getCapCorg() {
        return capCorg;
    }

    public void setCapCorg(String capCorg) {
        this.capCorg = capCorg;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getCvn2() {
        return cvn2;
    }

    public void setCvn2(String cvn2) {
        this.cvn2 = cvn2;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getMblNo() {
        return mblNo;
    }

    public void setMblNo(String mblNo) {
        this.mblNo = mblNo;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
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

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }


}
