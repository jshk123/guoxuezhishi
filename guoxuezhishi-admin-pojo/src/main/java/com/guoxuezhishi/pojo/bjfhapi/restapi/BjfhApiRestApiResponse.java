package com.guoxuezhishi.pojo.bjfhapi.restapi;

import com.icbc.api.IcbcResponse;
import com.icbc.api.internal.util.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author: jiang
 * @date: 2019/7/8
 */
public class BjfhApiRestApiResponse extends IcbcResponse {

    @JSONField(name = "eventNo")
    private String eventNo;

    @JSONField(name = "smsSendNo")
    private String smsSendNo;

    @JSONField(name = "corpSerno")
    private String corpSerno;

    @JSONField(name = "mediumId")
    private String mediumId;

    @JSONField(name = "sFlag")
    private String sFlag;

    @JSONField(name = "accountBalance")
    private String accountBalance;

    @JSONField(name = "accountUseamt")
    private String accountUseamt;
    @JSONField(name = "riskLevelMsg")
    private String riskLevelMsg;

    @JSONField(name = "riskLevel")
    private String riskLevel;

    @JSONField(name = "riskDate")
    private String riskDate;

    @JSONField(name = "sCardNo")
    private String sCardNo;

    @JSONField(name = "retCode")
    private String retCode;

    @JSONField(name = "retMsg")
    private String retMsg;

    @JSONField(name = "totalSum")
    private String totalSum;

    @JSONField(name = "openFlag")
    private String openFlag;

    @JSONField(name = "phone")
    private String phone;

    @JSONField(name = "cardBalance")
    private String cardBalance;

    @JSONField(name = "fundBalance")
    private String fundBalance;

    @JSONField(name = "recordFlag")
    private String recordFlag;

    @JSONField(name = "openDate")
    private String openDate;

    @JSONField(name = "pageNo")
    private String pageNo;

    @JSONField(name = "startSN")
    private String startSN;

    @JSONField(name = "endSN")
    private String endSN;

    @JSONField(name = "continueFlag")
    private String continueFlag;

    @JSONField(name = "tradeInfo")
    private List<TradeInfo> tradeInfo;

    @JSONField(name = "count")
    private String count;

    @JSONField(name = "cardInfo")
    private List<CardInfo> cardInfo;

    @JSONField(name = "pageFlag")
    private String pageFlag;

    @JSONField(name = "failFlag")
    private String failFlag;
    @JSONField(name = "smsId")
    private String smsId;

    public String getEventNo() {
        return eventNo;
    }

    public void setEventNo(String eventNo) {
        this.eventNo = eventNo;
    }

    public String getSmsSendNo() {
        return smsSendNo;
    }

    public void setSmsSendNo(String smsSendNo) {
        this.smsSendNo = smsSendNo;
    }

    public String getCorpSerno() {
        return corpSerno;
    }

    public void setCorpSerno(String corpSerno) {
        this.corpSerno = corpSerno;
    }

    public String getMediumId() {
        return mediumId;
    }

    public void setMediumId(String mediumId) {
        this.mediumId = mediumId;
    }

    public String getsFlag() {
        return sFlag;
    }

    public void setsFlag(String sFlag) {
        this.sFlag = sFlag;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountUseamt() {
        return accountUseamt;
    }

    public void setAccountUseamt(String accountUseamt) {
        this.accountUseamt = accountUseamt;
    }

    public String getRiskLevelMsg() {
        return riskLevelMsg;
    }

    public void setRiskLevelMsg(String riskLevelMsg) {
        this.riskLevelMsg = riskLevelMsg;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getRiskDate() {
        return riskDate;
    }

    public void setRiskDate(String riskDate) {
        this.riskDate = riskDate;
    }

    public String getsCardNo() {
        return sCardNo;
    }

    public void setsCardNo(String sCardNo) {
        this.sCardNo = sCardNo;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(String totalSum) {
        this.totalSum = totalSum;
    }

    public String getOpenFlag() {
        return openFlag;
    }

    public void setOpenFlag(String openFlag) {
        this.openFlag = openFlag;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(String cardBalance) {
        this.cardBalance = cardBalance;
    }

    public String getFundBalance() {
        return fundBalance;
    }

    public void setFundBalance(String fundBalance) {
        this.fundBalance = fundBalance;
    }

    public String getRecordFlag() {
        return recordFlag;
    }

    public void setRecordFlag(String recordFlag) {
        this.recordFlag = recordFlag;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getStartSN() {
        return startSN;
    }

    public void setStartSN(String startSN) {
        this.startSN = startSN;
    }

    public String getEndSN() {
        return endSN;
    }

    public void setEndSN(String endSN) {
        this.endSN = endSN;
    }

    public String getContinueFlag() {
        return continueFlag;
    }

    public void setContinueFlag(String continueFlag) {
        this.continueFlag = continueFlag;
    }

    public List<TradeInfo> getTradeInfo() {
        return tradeInfo;
    }

    public void setTradeInfo(List<TradeInfo> tradeInfo) {
        this.tradeInfo = tradeInfo;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<CardInfo> getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(List<CardInfo> cardInfo) {
        this.cardInfo = cardInfo;
    }

    public String getPageFlag() {
        return pageFlag;
    }

    public void setPageFlag(String pageFlag) {
        this.pageFlag = pageFlag;
    }

    public String getFailFlag() {
        return failFlag;
    }

    public void setFailFlag(String failFlag) {
        this.failFlag = failFlag;
    }

    public String getSmsId() {
        return smsId;
    }

    public void setSmsId(String smsId) {
        this.smsId = smsId;
    }

    @Override
    public String toString() {
        return "BjfhApiRestApiResponse{" +
                "eventNo='" + eventNo + '\'' +
                ", smsSendNo='" + smsSendNo + '\'' +
                ", corpSerno='" + corpSerno + '\'' +
                ", mediumId='" + mediumId + '\'' +
                ", sFlag='" + sFlag + '\'' +
                ", accountBalance='" + accountBalance + '\'' +
                ", accountUseamt='" + accountUseamt + '\'' +
                ", riskLevelMsg='" + riskLevelMsg + '\'' +
                ", riskLevel='" + riskLevel + '\'' +
                ", riskDate='" + riskDate + '\'' +
                ", sCardNo='" + sCardNo + '\'' +
                ", retCode='" + retCode + '\'' +
                ", retMsg='" + retMsg + '\'' +
                ", totalSum='" + totalSum + '\'' +
                ", openFlag='" + openFlag + '\'' +
                ", phone='" + phone + '\'' +
                ", cardBalance='" + cardBalance + '\'' +
                ", fundBalance='" + fundBalance + '\'' +
                ", recordFlag='" + recordFlag + '\'' +
                ", openDate='" + openDate + '\'' +
                ", pageNo='" + pageNo + '\'' +
                ", startSN='" + startSN + '\'' +
                ", endSN='" + endSN + '\'' +
                ", continueFlag='" + continueFlag + '\'' +
                ", tradeInfo=" + tradeInfo +
                ", count='" + count + '\'' +
                ", cardInfo=" + cardInfo +
                ", pageFlag='" + pageFlag + '\'' +
                ", failFlag='" + failFlag + '\'' +
                ", smsId='" + smsId + '\'' +
                '}';
    }

    public class TradeInfo {
        @JSONField(name = "sequentNo")
        private String sequentNo;
        @JSONField(name = "fundCode")
        private String fundCode;
        @JSONField(name = "tradeType")
        private String tradeType;
        @JSONField(name = "payAmt")
        private String payAmt;

        @JSONField(name = "tranDate")
        private String tranDate;
        @JSONField(name = "tranTime")
        private String tranTime;
        @JSONField(name = "status")
        private String status;
        @JSONField(name = "errMsg")
        private String errMsg;

        public String getSequentNo() {
            return sequentNo;
        }

        public void setSequentNo(String sequentNo) {
            this.sequentNo = sequentNo;
        }

        public String getFundCode() {
            return fundCode;
        }

        public void setFundCode(String fundCode) {
            this.fundCode = fundCode;
        }

        public String getTradeType() {
            return tradeType;
        }

        public void setTradeType(String tradeType) {
            this.tradeType = tradeType;
        }

        public String getPayAmt() {
            return payAmt;
        }

        public void setPayAmt(String payAmt) {
            this.payAmt = payAmt;
        }

        public String getTranDate() {
            return tranDate;
        }

        public void setTranDate(String tranDate) {
            this.tranDate = tranDate;
        }

        public String getTranTime() {
            return tranTime;
        }

        public void setTranTime(String tranTime) {
            this.tranTime = tranTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getErrMsg() {
            return errMsg;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }

        @Override
        public String toString() {
            return "TradeInfo{" +
                    "sequentNo='" + sequentNo + '\'' +
                    ", fundCode='" + fundCode + '\'' +
                    ", tradeType='" + tradeType + '\'' +
                    ", payAmt='" + payAmt + '\'' +
                    ", tranDate='" + tranDate + '\'' +
                    ", tranTime='" + tranTime + '\'' +
                    ", status='" + status + '\'' +
                    ", errMsg='" + errMsg + '\'' +
                    '}';
        }
    }

    public class CardInfo {
        @JSONField(name = "cardNo")
        private String cardNo;

        @JSONField(name = "bankNo")
        private String bankNo;

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

        @Override
        public String toString() {
            return "CardInfo{" +
                    "cardNo='" + cardNo + '\'' +
                    ", bankNo='" + bankNo + '\'' +
                    '}';
        }
    }

}
