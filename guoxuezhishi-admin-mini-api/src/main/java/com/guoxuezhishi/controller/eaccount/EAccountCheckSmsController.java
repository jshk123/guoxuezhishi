package com.guoxuezhishi.controller.eaccount;

import com.guoxuezhishi.pojo.eaccount.EAccountCheckBO;
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
@Api(value = "工行二类户校验验证码", tags = {"工行二类户校验验证码"})
public class EAccountCheckSmsController {
    @PostMapping("/EAccountCheckSms")
    @ApiOperation(value = "EAccountCheckSms", notes = "EAccountCheckSms")
    public GXJSONResult eAccountOpen(@RequestBody EAccountCheckBO eAccountCheckBO) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("version", eAccountCheckBO.getVersion());
        map.put("requestTime", eAccountCheckBO.getRequestTime());
        map.put("bussId", eAccountCheckBO.getBussId());
        map.put("smsCode", eAccountCheckBO.getSmsCode());
        map.put("smsNumber", eAccountCheckBO.getSmsNumber());
        map.put("orderNo", eAccountCheckBO.getOrderNo());
        map.put("type", eAccountCheckBO.getType());
        String reqUrl = String.valueOf(eAccountCheckBO.getReqCPFUrl() + "stpay/EAccountCheckSms.do");
        JSONObject reqPara = JSONObject.fromObject(map);
        String response = HttpUtils.sendPost(reqUrl, reqPara.toString(), "UTF-8");
        JSONObject rspponse = JSONObject.fromObject(response);
        return GXJSONResult.ok(rspponse);
    }
}

