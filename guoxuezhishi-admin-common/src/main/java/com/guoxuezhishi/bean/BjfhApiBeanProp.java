package com.guoxuezhishi.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: jiang
 * @date: 2019/7/5
 */
@Component
@ConfigurationProperties(prefix = "bjfh")
@PropertySource("bjfhapi.properties")
public class BjfhApiBeanProp {
    private String appId;
    private String corpNo;
    private String myPrivateKey;
    private String apigwPublickKey;
    private String serviceUrl;
    private String aesKey;
    private String proxyIp;
    private String proxyPort;
    private String accOpen;
    private String codeSend;
    private String codeCheck;
    private String depMoney;
    private String qryAcc;
    private String qryTraInfo;
    private String qryBindList;
    private String unBind;
    private String bindCard;
    private String wdMoney;
    private String fzAcc;
    private String unFz;
    private String sendCode;
    private String checkCode;

    public String getAccOpen() {
        return accOpen;
    }

    public void setAccOpen(String accOpen) {
        this.accOpen = accOpen;
    }

    public String getCodeSend() {
        return codeSend;
    }

    public void setCodeSend(String codeSend) {
        this.codeSend = codeSend;
    }

    public String getCodeCheck() {
        return codeCheck;
    }

    public void setCodeCheck(String codeCheck) {
        this.codeCheck = codeCheck;
    }

    public String getDepMoney() {
        return depMoney;
    }

    public void setDepMoney(String depMoney) {
        this.depMoney = depMoney;
    }

    public String getQryAcc() {
        return qryAcc;
    }

    public void setQryAcc(String qryAcc) {
        this.qryAcc = qryAcc;
    }

    public String getQryTraInfo() {
        return qryTraInfo;
    }

    public void setQryTraInfo(String qryTraInfo) {
        this.qryTraInfo = qryTraInfo;
    }

    public String getQryBindList() {
        return qryBindList;
    }

    public void setQryBindList(String qryBindList) {
        this.qryBindList = qryBindList;
    }

    public String getUnBind() {
        return unBind;
    }

    public void setUnBind(String unBind) {
        this.unBind = unBind;
    }

    public String getBindCard() {
        return bindCard;
    }

    public void setBindCard(String bindCard) {
        this.bindCard = bindCard;
    }

    public String getWdMoney() {
        return wdMoney;
    }

    public void setWdMoney(String wdMoney) {
        this.wdMoney = wdMoney;
    }

    public String getFzAcc() {
        return fzAcc;
    }

    public void setFzAcc(String fzAcc) {
        this.fzAcc = fzAcc;
    }

    public String getUnFz() {
        return unFz;
    }

    public void setUnFz(String unFz) {
        this.unFz = unFz;
    }

    public String getSendCode() {
        return sendCode;
    }

    public void setSendCode(String sendCode) {
        this.sendCode = sendCode;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getProxyIp() {
        return proxyIp;
    }

    public void setProxyIp(String proxyIp) {
        this.proxyIp = proxyIp;
    }

    public String getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(String proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

    public String getCorpNo() {
        return corpNo;
    }

    public void setCorpNo(String corpNo) {
        this.corpNo = corpNo;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMyPrivateKey() {
        return myPrivateKey;
    }

    public void setMyPrivateKey(String myPrivateKey) {
        this.myPrivateKey = myPrivateKey;
    }

    public String getApigwPublickKey() {
        return apigwPublickKey;
    }

    public void setApigwPublickKey(String apigwPublickKey) {
        this.apigwPublickKey = apigwPublickKey;
    }
}
