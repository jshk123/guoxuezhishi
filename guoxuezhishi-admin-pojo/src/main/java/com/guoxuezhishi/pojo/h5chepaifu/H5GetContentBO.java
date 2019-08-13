package com.guoxuezhishi.pojo.h5chepaifu;

import com.guoxuezhishi.pojo.BaseBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/7/2
 */
@ApiModel(value = "车牌付获取文案", description = "车牌付获取文案")
public class H5GetContentBO extends BaseBO {
    @ApiModelProperty(value = "", name = "", example = "1", required = true)
    private String contentId;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

}
