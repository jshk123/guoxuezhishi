package com.guoxuezhishi.pojo.jiaohangyun;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/8/13
 */
@ApiModel(value = "交通银行云账户划拨", description = "交通银行云账户划拨")
public class CloudTransferAccountDO {
    @ApiModelProperty(value = "主账号", name = "主账号", example = "", required = true)
    private String acc;
    @ApiModelProperty(value = "交易流水号", name = "交易流水号", example = "", required = true)
    private String ordNo;
    @ApiModelProperty(value = "付款云账户", name = "付款云账户", example = "", required = true)
    private String payAcno;
    @ApiModelProperty(value = "付款云账户名称", name = "付款云账户名称", example = "", required = true)
    private String payAcname;
    @ApiModelProperty(value = "收款云账户", name = "收款云账户", example = "", required = true)
    private String rcvAcno;
    @ApiModelProperty(value = "收款云账户名称", name = "收款云账户名称", example = "", required = true)
    private String rcvAcname;
    @ApiModelProperty(value = "划拨金额", name = "划拨金额", example = "", required = true)
    private String amt;
    @ApiModelProperty(value = "收款行类别", name = "收款行类别", example = "0", required = false)
    private String bankFlag;
    @ApiModelProperty(value = "收款行行名", name = "收款行行名", example = "", required = false)
    private String rcvBankName;
    @ApiModelProperty(value = "收款行行号", name = "收款行行号", example = "", required = false)
    private String rcvBankNo;

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getOrdNo() {
        return ordNo;
    }

    public void setOrdNo(String ordNo) {
        this.ordNo = ordNo;
    }

    public String getPayAcno() {
        return payAcno;
    }

    public void setPayAcno(String payAcno) {
        this.payAcno = payAcno;
    }

    public String getPayAcname() {
        return payAcname;
    }

    public void setPayAcname(String payAcname) {
        this.payAcname = payAcname;
    }

    public String getRcvAcno() {
        return rcvAcno;
    }

    public void setRcvAcno(String rcvAcno) {
        this.rcvAcno = rcvAcno;
    }

    public String getRcvAcname() {
        return rcvAcname;
    }

    public void setRcvAcname(String rcvAcname) {
        this.rcvAcname = rcvAcname;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getBankFlag() {
        return bankFlag;
    }

    public void setBankFlag(String bankFlag) {
        this.bankFlag = bankFlag;
    }

    public String getRcvBankName() {
        return rcvBankName;
    }

    public void setRcvBankName(String rcvBankName) {
        this.rcvBankName = rcvBankName;
    }

    public String getRcvBankNo() {
        return rcvBankNo;
    }

    public void setRcvBankNo(String rcvBankNo) {
        this.rcvBankNo = rcvBankNo;
    }
}
