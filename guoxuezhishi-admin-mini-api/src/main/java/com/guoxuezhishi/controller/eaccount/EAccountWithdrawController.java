package com.guoxuezhishi.controller.eaccount;

import com.guoxuezhishi.pojo.eaccount.EAccountWithdrawBO;
import com.guoxuezhishi.utils.GXJSONResult;
import com.guoxuezhishi.utils.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: jiang
 * @date: 2019/7/1
 */
@RestController
@Api(value = "工行二类户提现", tags = {"工行二类户提现"})
public class EAccountWithdrawController {
    @PostMapping("/EAccountWithdraw")
    @ApiOperation(value = "EAccountWithdraw", notes = "EAccountWithdraw")
    public GXJSONResult eAccountWithdraw(@RequestBody EAccountWithdrawBO eAccountWithdrawBO) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("version", eAccountWithdrawBO.getVersion());
        map.put("requestTime", eAccountWithdrawBO.getRequestTime());
        map.put("bussId", eAccountWithdrawBO.getBussId());
        map.put("outOrderNo", eAccountWithdrawBO.getOutOrderNo());
        String reqUrl = String.valueOf(eAccountWithdrawBO.getReqCPFUrl() + "stpay/EAccountWithdraw.do");
        JSONObject reqPara = JSONObject.fromObject(map);
        String response = HttpUtils.sendPost(reqUrl, reqPara.toString(), "UTF-8");
        return GXJSONResult.ok(response);

    }
}
