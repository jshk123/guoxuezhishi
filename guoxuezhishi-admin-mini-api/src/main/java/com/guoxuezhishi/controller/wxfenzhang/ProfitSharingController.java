package com.guoxuezhishi.controller.wxfenzhang;

import com.guoxuezhishi.pojo.wxfenzhang.ProfitSharingBO;
import com.guoxuezhishi.utils.GXJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: jiang
 * @date: 2019/7/3
 */
@RestController
@Api(value = "请求单次分账", tags = {"请求单次分账"})
public class ProfitSharingController {
    @PostMapping("")
    @ApiOperation(value = "ProfitSharing", notes = "ProfitSharing")
    public GXJSONResult profitSharing(@RequestBody ProfitSharingBO profitSharingBO) {
        Map<String,Object> map = new HashMap<>();

        String reqUrl = String.valueOf(profitSharingBO.getReqWXUrl() + "secapi/pay/profitsharing");
        return GXJSONResult.ok();
    }
}
