package com.guoxuezhishi.pojo.bjfhapi.restapi;

import com.icbc.api.AbstractIcbcRequest;
import com.icbc.api.BizContent;
import com.icbc.api.internal.util.fastjson.annotation.JSONField;

/**
 * @author: jiang
 * @date: 2019/7/8
 */
public class BjfhApiRestApiRequest extends AbstractIcbcRequest<BjfhApiRestApiResponse> {

    public BjfhApiRestApiRequest() {
    }

    @Override
    public Class<BjfhApiRestApiResponse> getResponseClass() {
        return BjfhApiRestApiResponse.class;
    }

    @Override
    public boolean isNeedEncrypt() {
        return false;
    }

    @Override
    public String getMethod() {
        return "POST";
    }

    @Override
    public Class<? extends BizContent> getBizContentClass() {
        return BjfhApiRestApiRequestBiz.class;
    }

    public static class BjfhApiRestApiRequestBiz implements BizContent {

        @JSONField(name = "sCardNo")
        private String sCardNo;

        @JSONField(name = "cardNo")
        private String cardNo;

        @JSONField(name = "bankNo")
        private String bankNo;

        @JSONField(name = "certType")
        private String certType;

        @JSONField(name = "certNo")
        private String certNo;

        @JSONField(name = "name")
        private String name;

        @JSONField(name = "phone")
        private String phone;

        @JSONField(name = "id")
        private String id;

        @JSONField(name = "sendNo")
        private String sendNo;

        @JSONField(name = "sCode")
        private String sCode;

        @JSONField(name = "oserNo")
        private String oserNo;

        @JSONField(name = "oType")
        private String oType;

        @JSONField(name = "amount")
        private String amount;

        @JSONField(name = "corpNo")
        private String corpNo;

        @JSONField(name = "period")
        private String period;

        @JSONField(name = "param")
        private String param;

        @JSONField(name = "tradeType")
        private String tradeType;

        @JSONField(name = "startDate")
        private String startDate;

        @JSONField(name = "endDate")
        private String endDate;

        @JSONField(name = "corpSerno")
        private String corpSerno;

        @JSONField(name = "tranFlag")
        private String tranFlag;

        @JSONField(name = "smsId")
        private String smsId;

        @JSONField(name = "code")
        private String code;

        @JSONField(name = "channel")
        private String channel;

        @JSONField(name = "gender")
        private String gender;

        @JSONField(name = "nationality")
        private String nationality;

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getsCardNo() {
            return sCardNo;
        }

        public void setsCardNo(String sCardNo) {
            this.sCardNo = sCardNo;
        }

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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSendNo() {
            return sendNo;
        }

        public void setSendNo(String sendNo) {
            this.sendNo = sendNo;
        }

        public String getsCode() {
            return sCode;
        }

        public void setsCode(String sCode) {
            this.sCode = sCode;
        }

        public String getOserNo() {
            return oserNo;
        }

        public void setOserNo(String oserNo) {
            this.oserNo = oserNo;
        }

        public String getoType() {
            return oType;
        }

        public void setoType(String oType) {
            this.oType = oType;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCorpNo() {
            return corpNo;
        }

        public void setCorpNo(String corpNo) {
            this.corpNo = corpNo;
        }

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
        }

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public String getTradeType() {
            return tradeType;
        }

        public void setTradeType(String tradeType) {
            this.tradeType = tradeType;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getCorpSerno() {
            return corpSerno;
        }

        public void setCorpSerno(String corpSerno) {
            this.corpSerno = corpSerno;
        }

        public String getTranFlag() {
            return tranFlag;
        }

        public void setTranFlag(String tranFlag) {
            this.tranFlag = tranFlag;
        }

        public String getSmsId() {
            return smsId;
        }

        public void setSmsId(String smsId) {
            this.smsId = smsId;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        @Override
        public String toString() {
            return "BjfhApiRestApiRequestBiz{" +
                    "sCardNo='" + sCardNo + '\'' +
                    ", cardNo='" + cardNo + '\'' +
                    ", bankNo='" + bankNo + '\'' +
                    ", certType='" + certType + '\'' +
                    ", certNo='" + certNo + '\'' +
                    ", name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    ", id='" + id + '\'' +
                    ", sendNo='" + sendNo + '\'' +
                    ", sCode='" + sCode + '\'' +
                    ", oserNo='" + oserNo + '\'' +
                    ", oType='" + oType + '\'' +
                    ", amount='" + amount + '\'' +
                    ", corpNo='" + corpNo + '\'' +
                    ", period='" + period + '\'' +
                    ", param='" + param + '\'' +
                    ", tradeType='" + tradeType + '\'' +
                    ", startDate='" + startDate + '\'' +
                    ", endDate='" + endDate + '\'' +
                    ", corpSerno='" + corpSerno + '\'' +
                    ", tranFlag='" + tranFlag + '\'' +
                    ", smsId='" + smsId + '\'' +
                    ", code='" + code + '\'' +
                    ", channel='" + channel + '\'' +
                    ", gender='" + gender + '\'' +
                    ", nationality='" + nationality + '\'' +
                    '}';
        }
    }
}

