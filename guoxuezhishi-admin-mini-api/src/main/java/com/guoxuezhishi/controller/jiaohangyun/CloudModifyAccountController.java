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
@Api(value = "交通银行云账户修改处理", tags = "交通银行云账户修改处理")
public class CloudModifyAccountController {
    @PostMapping("/CloudModifyAccount")
    @ApiOperation(value = "CloudModifyAccount", notes = " CloudModifyAccount")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cloud_acc", value = "云账号", defaultValue = "bjetc-1234567891230001", required = true, dataType = "String", paramType = "query")
            ,
            @ApiImplicitParam(name = "cloud_acc_name", value = "云账户名称", defaultValue = "停车场云账号名称测试1", required = true, dataType = "String", paramType = "query")
            ,
            @ApiImplicitParam(name = "acc", value = "主账号", defaultValue = "110060973018010061105", required = true, dataType = "String", paramType = "query")
            ,
            @ApiImplicitParam(name = "super_acc", value = "上级云账号", defaultValue = "110060973018010061105", required = true, dataType = "String", paramType = "query")
            ,
            @ApiImplicitParam(name = "tran_type", value = "操作类型", defaultValue = "0", required = true, dataType = "String", paramType = "query")
    })
    public GXJSONResult remoteCommand(String cloud_acc, String cloud_acc_name, String acc, String super_acc, String tran_type) {
        StringBuffer reqUrl = new StringBuffer();
        reqUrl.append("http://172.20.53.130:8280/sysmng/bpcspub3/cloudModifyAccount.do")
                .append("?cloud_acc=").append(cloud_acc)
                .append("&cloud_acc_name=").append(cloud_acc_name)
                .append("&acc=").append(acc)
                .append("&super_acc=").append(super_acc)
                .append("&tran_type=").append(tran_type);
        String response = HttpUtils.sendPost(reqUrl.toString(), "", "UTF-8");
        JSONObject rsponse = JSONObject.fromObject(response);
        return GXJSONResult.ok(rsponse);
    }

}
