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
 * @date: 2019/8/12
 */
@RestController
@Api(value = "交通银行云账户对账文件处理", tags = "交通银行云账户对账文件处理")
public class CloudCheckFileController {
    @PostMapping("/CloudCheckFile")
    @ApiOperation(value = "CloudCheckFile", notes = " CloudCheckFile")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "request_time", value = "请求时间", defaultValue = "20190812121212", required = true, dataType = "String", paramType = "query")
            ,
            @ApiImplicitParam(name = "check_date", value = "对账时间", defaultValue = "20190809", required = true, dataType = "String", paramType = "query")
    })
    public GXJSONResult remoteCommand(String request_time, String check_date) {
        StringBuffer reqUrl = new StringBuffer();
        reqUrl.append("http://172.20.53.130:8280/sysmng/bpcspub3/cloudCheckFile.do")
                .append("?request_time=").append(request_time)
                .append("&check_date=").append(check_date);
        String response = HttpUtils.sendPost(reqUrl.toString(), "", "UTF-8");
        JSONObject rsponse = JSONObject.fromObject(response);
        return GXJSONResult.ok(rsponse);
    }

}
