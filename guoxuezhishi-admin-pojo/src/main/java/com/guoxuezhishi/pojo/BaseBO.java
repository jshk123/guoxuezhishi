package com.guoxuezhishi.pojo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/7/2
 */
public class BaseBO {
//    @ApiModelProperty(value = "", name = "", example = "http://202.106.235.34:10025/", required = true)
    @ApiModelProperty(value = "", name = "", example = "http://172.20.53.123:8680/", required = true)
    private String reqCPFUrl;

    public String getReqCPFUrl() {
        return reqCPFUrl;
    }

    public void setReqCPFUrl(String reqCPFUrl) {
        this.reqCPFUrl = reqCPFUrl;
    }
}



