package com.guoxuezhishi.pojo.eaccount;

import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/7/1
 */
public class EAccountOpenBO extends BaseBO {
    @ApiModelProperty(value = "", name = "", example = "1.0", required = true)
    private String version;
    @ApiModelProperty(value = "", name = "", example = "20190610100000", required = true)
    private String requestTime;
    @ApiModelProperty(value = "", name = "", example = "icbc", required = true)
    private String bussId;
    @ApiModelProperty(value = "", name = "", example = "20190610100000", required = true)
    private String outOrderNo;
    @ApiModelProperty(value = "", name = "", example = "20190610100000", required = true)
    private String outJrnNo;
    @ApiModelProperty(value = "", name = "", example = "6212260200055910902", required = true)
    private String cardNo;
    @ApiModelProperty(value = "", name = "", example = "乐已魂", required = true)
    private String name;
    @ApiModelProperty(value = "", name = "", example = "0", required = true)
    private String certType;
    @ApiModelProperty(value = "", name = "", example = "522998196903134866", required = true)
    private String certNo;
    @ApiModelProperty(value = "", name = "", example = "13881826458", required = true)
    private String mobileNo;
    @ApiModelProperty(value = "", name = "", example = "2020-01-01", required = true)
    private String period;
    @ApiModelProperty(value = "", name = "", example = "iVBORw0KGgoAAAANSUhEUgAAAZEAAACDCAIAAADDKrEkAAAgAElEQVR4AaS9B4BtVX32feZMnzu3Fy5NJGBHfe0dCyqKGqOxdxLFgl0s0dggSlQQS9QYMTEaOwYFRRRbNDF2QUGaBaVebp+ZO33OfL/nedba58wFzfvlXffcddb6l+dfVjl777PPnr7Z2dlWq9U3PDzzzf/Y+75/6uzc3Tc22mq3W319fS3+LcNIggg==", required = true)
    private String pictureFront;
    @ApiModelProperty(value = "", name = "", example = "iVBORw0KGgoAAAANSUhEUgAAAZq0CkXnPG22Y++onO3JTubn/n3/FXsMbf8Mpegf3aXHTf8JXPXkuorTwza7mV26/2k2u1Jr/0Vb6VUBCaSbwzUch+Po4yxs6IZxv7y9Dtb8uB6AHvf/vOv3s3z4PfsefXvnkZx+95PK95=", required = true)
    private String pictureBehind;
    @ApiModelProperty(value = "", name = "", example = "1", required = true)
    private String occupation;
    @ApiModelProperty(value = "", name = "", example = "北京市", required = true)
    private String address;


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getBussId() {
        return bussId;
    }

    public void setBussId(String bussId) {
        this.bussId = bussId;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getOutJrnNo() {
        return outJrnNo;
    }

    public void setOutJrnNo(String outJrnNo) {
        this.outJrnNo = outJrnNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPictureFront() {
        return pictureFront;
    }

    public void setPictureFront(String pictureFront) {
        this.pictureFront = pictureFront;
    }

    public String getPictureBehind() {
        return pictureBehind;
    }

    public void setPictureBehind(String pictureBehind) {
        this.pictureBehind = pictureBehind;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
