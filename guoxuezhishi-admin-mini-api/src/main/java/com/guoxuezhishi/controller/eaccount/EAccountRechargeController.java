package com.guoxuezhishi.controller.eaccount;

import com.guoxuezhishi.pojo.eaccount.EAccountRechargeBO;
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
@Api(value = "工行二类户充值", tags = {"工行二类户充值"})
public class EAccountRechargeController {
    @PostMapping("/EAccountRecharge")
    @ApiOperation(value = "EAccountRecharge", notes = "EAccountRecharge")
    public GXJSONResult eAccountRecharge(@RequestBody EAccountRechargeBO eAccountRechargeBO) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("version", eAccountRechargeBO.getVersion());
        map.put("requestTime", eAccountRechargeBO.getRequestTime());
        map.put("bussId", eAccountRechargeBO.getBussId());
        map.put("outOrderNo", eAccountRechargeBO.getOutOrderNo());
        map.put("flag", eAccountRechargeBO.getFlag());
        map.put("sCardNo", eAccountRechargeBO.getsCardNo());
        map.put("amount", eAccountRechargeBO.getAmount());
        String reqUrl = String.valueOf(eAccountRechargeBO.getReqCPFUrl() + "stpay/EAccountRecharge.do");
        JSONObject reqPara = JSONObject.fromObject(map);
        String response = HttpUtils.sendPost(reqUrl, reqPara.toString(), "UTF-8");
        JSONObject rspponse = JSONObject.fromObject(response);
        return GXJSONResult.ok(rspponse);
    }
}
