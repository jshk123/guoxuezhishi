package com.guoxuezhishi.pojo.bjfhapi;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/7/9
 */
public class OpenAccountBO {
    @ApiModelProperty(example = "122997196301263555", required = true)
    private String cardNo;

    @ApiModelProperty(example = "1", required = true)
    private String bankNo;

    @ApiModelProperty(example = "0", required = true)
    private String certType;

    @ApiModelProperty(example = "122999196803250167", required = true)
    private String certNo;

    @ApiModelProperty(example = "忆俭浆", required = true)
    private String name;

    @ApiModelProperty(example = "15910701549", required = true)
    private String phone;

    @ApiModelProperty(example = "2020-12-12", required = true)
    private String period;

    @ApiModelProperty(example = "15910701549", required = true)
    private String id;

    @ApiModelProperty(example = "iVBORw0KGgoAAAANSUhEUgAAAZEAAACDCAIAAADDKrEkAAAgAElEQVR4AaS9B4BtVX32feZMnzu3Fy5NJGBHfe0dCyqKGqOxdxLFgl0s0dggSlQQS9QYMTEaOwYFRRRbNDF", required = true)
    private String pictureFront;

    @ApiModelProperty(example = "iVBORw0KGgoAAAANSUhEUgAAAZEAAACDCAIAAADDKrEkAAAgAElEQVR4AaS9B4BtVX32feZMnzu3Fy5NJGBHfe0dCyqKGqOxdxLFgl0s0dggSlQQS9QYMTEaOwYFRRRbNDF2QUGaBaVebp+ZO33OfL", required = true)
    private String pictureBehind;

    @ApiModelProperty(name = "", value = "1、男；2、女", example = "1", required = true)
    private String gender;

    @ApiModelProperty(example = "156", required = true)
    private String nationality;

    @ApiModelProperty(example = "1", required = true)
    private String occupation;

    @ApiModelProperty(example = "北京市", required = true)
    private String address;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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
