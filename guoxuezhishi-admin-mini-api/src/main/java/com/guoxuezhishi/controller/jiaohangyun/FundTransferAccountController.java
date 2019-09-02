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
 * @date: 2019/8/28
 */
@RestController
@Api(value = "划拨处理", tags = "划拨处理")
public class FundTransferAccountController {
    @PostMapping("/FundTransferAccount")
    @ApiOperation(value = "FundTransferAccount", notes = " FundTransferAccount")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tx_dt", value = "划拨时间", defaultValue = "20190828", required = true, dataType = "String", paramType = "query")
    })
    public GXJSONResult remoteCommand(String tx_dt) {
        StringBuffer reqUrl = new StringBuffer();
        reqUrl.append("http://172.20.53.130:8280/sysmng/bpcspub3/fundTransferAccount.do")
                .append("?gda.tx_dt=").append(tx_dt);
        String response = HttpUtils.sendPost(reqUrl.toString(), "", "UTF-8");
        JSONObject rsponse = JSONObject.fromObject(response);
        return GXJSONResult.ok(rsponse);
    }
}

