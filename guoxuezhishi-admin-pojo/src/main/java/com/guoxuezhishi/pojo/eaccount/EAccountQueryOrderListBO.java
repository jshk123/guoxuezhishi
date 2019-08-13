package com.guoxuezhishi.pojo.eaccount;

import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/7/1
 */
public class EAccountQueryOrderListBO extends BaseBO {
    @ApiModelProperty(value = "", name = "", example = "1.0", required = true)
    private String version;
    @ApiModelProperty(value = "", name = "", example = "20190610100000", required = true)
    private String requestTime;
    @ApiModelProperty(value = "", name = "", example = "icbc", required = true)
    private String bussId;
    @ApiModelProperty(value = "", name = "", example = "6214760200606476247", required = true)
    private String sCardNo;
    @ApiModelProperty(value = "", name = "", example = "0", required = true)
    private String type;
    @ApiModelProperty(value = "", name = "", example = "20190501", required = true)
    private String startDate;
    @ApiModelProperty(value = "", name = "", example = "20191001", required = true)
    private String endDate;


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

    public String getsCardNo() {
        return sCardNo;
    }

    public void setsCardNo(String sCardNo) {
        this.sCardNo = sCardNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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


}
