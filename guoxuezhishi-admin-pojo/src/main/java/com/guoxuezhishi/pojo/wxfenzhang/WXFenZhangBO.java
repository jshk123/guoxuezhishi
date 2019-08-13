package com.guoxuezhishi.pojo.wxfenzhang;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/7/5
 */
public class WXFenZhangBO {
    @ApiModelProperty(value = "", name = "", example = "https://api.mch.weixin.qq.com/", required = true)
    private String reqWXUrl;

    public String getReqWXUrl() {
        return reqWXUrl;
    }

    public void setReqWXUrl(String reqWXUrl) {
        this.reqWXUrl = reqWXUrl;
    }
}
