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
@Api(value = "交通银行云账户划拨查询", tags = "交通银行云账户划拨查询")
public class CloudTransferAccountQueryController {
    @PostMapping("/CloudTransferAccountQuery")
    @ApiOperation(value = "CloudTransferAccountQuery", notes = " CloudTransferAccountQuery")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ord_no", value = "交易流水号", defaultValue = "2019081301026666", required = true, dataType = "String", paramType = "query")
    })
    public GXJSONResult remoteCommand(String ord_no) {
        StringBuffer reqUrl = new StringBuffer();
        reqUrl.append("http://172.20.53.130:8280/sysmng/bpcspub3/cloudTransferAccountQuery.do")
                .append("?ord_no=").append(ord_no);
        String response = HttpUtils.sendPost(reqUrl.toString(), "", "UTF-8");
        JSONObject rsponse = JSONObject.fromObject(response);
        return GXJSONResult.ok(rsponse);
    }
}
