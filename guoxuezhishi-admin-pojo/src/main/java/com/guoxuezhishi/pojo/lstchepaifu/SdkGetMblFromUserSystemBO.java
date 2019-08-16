package com.guoxuezhishi.pojo.lstchepaifu;

import com.guoxuezhishi.pojo.BaseAppBO;
import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/8/14
 */
@ApiModel(value = "获取用户手机号", description = "获取用户手机号")
public class SdkGetMblFromUserSystemBO extends BaseAppBO {
    @ApiModelProperty(value = "customId", name = "customId", example = "bb050007-3524-47b5-8e83-0f63d3770a61", required = true)
    private String customId;
    @ApiModelProperty(value = "regTyp", name = "regTyp", example = "LST", required = true)
    private String regTyp;

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public String getRegTyp() {
        return regTyp;
    }

    public void setRegTyp(String regTyp) {
        this.regTyp = regTyp;
    }
}
