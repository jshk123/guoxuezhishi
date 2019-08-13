package com.guoxuezhishi.controller.jiaohangyun;

import com.guoxuezhishi.utils.GXJSONResult;
import com.guoxuezhishi.utils.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jiang
 * @date: 2019/8/5
 */
@RestController
@Api(value = "交通银行云账户余额查询", tags = "交通银行云账户余额查询")
public class CloudQueryBalanceController {
    @PostMapping("/CloudQueryBalance")
    @ApiOperation(value = "CloudQueryBalance", notes = " CloudQueryBalance")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cloud_acc", value = "云账号", defaultValue = "110060973018010061105", required = true, dataType = "String", paramType = "query")
    })
    public GXJSONResult remoteCommand(String cloud_acc) {
        StringBuffer reqUrl = new StringBuffer();
        reqUrl.append("http://172.20.53.130:8280/sysmng/bpcspub3/cloudQueryBalance.do")
                .append("?cloud_acc=").append(cloud_acc);
        String response = HttpUtils.sendPost(reqUrl.toString(), "", "UTF-8");
        JSONObject rsponse = JSONObject.fromObject(response);
        return GXJSONResult.ok(rsponse);
    }
}
