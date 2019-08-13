package com.guoxuezhishi.pojo.bjfhapi;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author: jiang
 * @date: 2019/7/8
 */

public class QueryAccountBO {
    @ApiModelProperty(example = "122999196803250167", required = true)
    private String certNo;

    @ApiModelProperty(example = "忆俭浆", required = true)
    private String name;

    @ApiModelProperty(example = "522019062514000033", required = true)
    private String id;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
