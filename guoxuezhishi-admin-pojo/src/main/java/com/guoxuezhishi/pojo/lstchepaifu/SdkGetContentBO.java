package com.guoxuezhishi.pojo.lstchepaifu;

import com.guoxuezhishi.pojo.BaseAppBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/10/11
 */
@ApiModel(value = "获取文案", description = "获取文案")
public class SdkGetContentBO extends BaseAppBO {
    @ApiModelProperty(value = "contentId", name = "contentId", example = "1", required = true)
    private String contentId;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }
}