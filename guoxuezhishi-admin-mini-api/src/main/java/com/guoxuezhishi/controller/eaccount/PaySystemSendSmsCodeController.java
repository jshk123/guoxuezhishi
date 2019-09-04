package com.guoxuezhishi.controller.eaccount;

import com.guoxuezhishi.pojo.eaccount.PaySystemSendSmsCodeBO;
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
 * @date: 2019/9/4
 * * 发送验证码
 */
@RestController
@Api(value = "发送短信验证码", tags = "发送短信验证码")
public class PaySystemSendSmsCodeController {
    @PostMapping("PaySystemSendSmsCode")
    @ApiOperation(value = "PaySystemSendSmsCode", notes = "PaySystemSendSmsCode")
    public GXJSONResult paySystemSendSmsCode(@RequestBody PaySystemSendSmsCodeBO paySystemSendSmsCodeBO) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("phoneNo", paySystemSendSmsCodeBO.getPhoneNo());
        map.put("bussType", paySystemSendSmsCodeBO.getBussType());
        String reqUrl = String.valueOf(paySystemSendSmsCodeBO.getReqCPFUrl() + "stpay/PaySystemSendSmsCode.do");
        JSONObject reqPara = JSONObject.fromObject(map);
        String response = HttpUtils.sendPost(reqUrl, reqPara.toString(), "UTF-8");
        return GXJSONResult.ok(response);
    }
}
