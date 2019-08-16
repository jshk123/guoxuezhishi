package com.guoxuezhishi.pojo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/7/2
 */
public class BaseAppBO extends BaseBO {
    @ApiModelProperty(value = "", name = "", example = "0", required = true)
    private String plat;
    @ApiModelProperty(value = "", name = "", example = "0", required = true)
    private String channel;
    @ApiModelProperty(value = "", name = "", example = "text/html", required = true)
    private String contentTyp;
    @ApiModelProperty(value = "", name = "", example = "小米8", required = true)
    private String deviceMod;
    @ApiModelProperty(value = "", name = "", example = "865166025422109", required = true)
    private String deviceID;
    @ApiModelProperty(value = "", name = "", example = "0", required = true)
    private String opSys;
    @ApiModelProperty(value = "", name = "", example = "5.1.1", required = true)
    private String opSysVer;
    @ApiModelProperty(value = "", name = "", example = "1", required = true)
    private String networkTyp;
    @ApiModelProperty(value = "", name = "", example = "", required = true)
    private String netServiceMer;
    @ApiModelProperty(value = "", name = "", example = "172.16.2.15", required = true)
    private String ipAddress;
    @ApiModelProperty(value = "", name = "", example = "zh", required = true)
    private String deviceLanguage;
    @ApiModelProperty(value = "", name = "", example = "9", required = true)
    private String clientVer;
    @ApiModelProperty(value = "", name = "", example = "02", required = true)
    private String characterSet;
    @ApiModelProperty(value = "", name = "", example = "", required = true)
    private String locationData;

    public String getNetServiceMer() {
        return netServiceMer;
    }

    public void setNetServiceMer(String netServiceMer) {
        this.netServiceMer = netServiceMer;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getContentTyp() {
        return contentTyp;
    }

    public void setContentTyp(String contentTyp) {
        this.contentTyp = contentTyp;
    }

    public String getDeviceMod() {
        return deviceMod;
    }

    public void setDeviceMod(String deviceMod) {
        this.deviceMod = deviceMod;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getOpSys() {
        return opSys;
    }

    public void setOpSys(String opSys) {
        this.opSys = opSys;
    }

    public String getOpSysVer() {
        return opSysVer;
    }

    public void setOpSysVer(String opSysVer) {
        this.opSysVer = opSysVer;
    }

    public String getNetworkTyp() {
        return networkTyp;
    }

    public void setNetworkTyp(String networkTyp) {
        this.networkTyp = networkTyp;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDeviceLanguage() {
        return deviceLanguage;
    }

    public void setDeviceLanguage(String deviceLanguage) {
        this.deviceLanguage = deviceLanguage;
    }

    public String getClientVer() {
        return clientVer;
    }

    public void setClientVer(String clientVer) {
        this.clientVer = clientVer;
    }

    public String getCharacterSet() {
        return characterSet;
    }

    public void setCharacterSet(String characterSet) {
        this.characterSet = characterSet;
    }

    public String getLocationData() {
        return locationData;
    }

    public void setLocationData(String locationData) {
        this.locationData = locationData;
    }
}



