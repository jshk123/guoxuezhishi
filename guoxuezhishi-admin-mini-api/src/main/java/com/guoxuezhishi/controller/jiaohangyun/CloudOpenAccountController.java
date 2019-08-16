package com.guoxuezhishi.controller.jiaohangyun;

import com.guoxuezhishi.utils.GXJSONResult;
import com.guoxuezhishi.utils.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

/**
 * @author: jiang
 * @date: 2019/8/5
 */
@RestController
@Api(value = "交通银行云账户开户", tags = "交通银行云账户开户")
public class CloudOpenAccountController {
    @Autowired
    private static Logger logger = Logger.getLogger(SpringBootApplication.class);
    @PostMapping("/CloudOpenAccount")
    @ApiOperation(value = "CloudOpenAccount", notes = " CloudOpenAccount")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cloud_acc", value = "云账号", defaultValue = "bjetc-1000000015150029", required = true, dataType = "String", paramType = "query")
            ,
            @ApiImplicitParam(name = "cloud_acc_name", value = "云账户名称", defaultValue = "发票推送停车场(修改)", required = true, dataType = "String", paramType = "query")
            ,
            @ApiImplicitParam(name = "acc", value = "主账号", defaultValue = "110060973018010061105", required = true, dataType = "String", paramType = "query")
            ,
            @ApiImplicitParam(name = "super_acc", value = "上级云账号", defaultValue = "110060973018010061105", required = true, dataType = "String", paramType = "query")
    })
    public GXJSONResult remoteCommand(String cloud_acc, String cloud_acc_name, String acc, String super_acc) {
        StringBuffer reqUrl = new StringBuffer();
        reqUrl.append("http://172.20.53.130:8280/sysmng/bpcspub3/cloudOpenAccount.do")
                .append("?cloud_acc=").append(cloud_acc)
                .append("&cloud_acc_name=").append(cloud_acc_name)
                .append("&acc=").append(acc)
                .append("&super_acc=").append(super_acc);
        logger.info("reqUrl:"+reqUrl.toString());
        String response = HttpUtils.sendPost(reqUrl.toString(), "", "UTF-8");
        JSONObject rsponse = JSONObject.fromObject(response);
        return GXJSONResult.ok(rsponse);
    }

}
