package com.guoxuezhishi.controller.h5chepaifu;

import com.guoxuezhishi.pojo.h5chepaifu.H5GetContentBO;
import com.guoxuezhishi.pojo.h5chepaifu.PlateSendSmsCodeBO;
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
@Api(value = "车牌付发送验证码", tags = {"车牌付发送验证码"})
public class PlateSendSmsCodeController {
    @PostMapping("/PlateSendSmsCode")
    @ApiOperation(value = "PlateSendSmsCode", notes = "PlateSendSmsCode")
    public GXJSONResult plateSendSmsCode(@RequestBody PlateSendSmsCodeBO plateSendSmsCodeBO) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("charset", plateSendSmsCodeBO.getCharset());
        map.put("version", plateSendSmsCodeBO.getVersion());
        map.put("service", plateSendSmsCodeBO.getService());
        map.put("requestTime", plateSendSmsCodeBO.getRequestTime());
        map.put("plateNo", plateSendSmsCodeBO.getPlateNo());
        map.put("cardNo", plateSendSmsCodeBO.getCardNo());
        map.put("mblNo", plateSendSmsCodeBO.getMblNo());
        map.put("vehplateColor", plateSendSmsCodeBO.getVehplateColor());
        map.put("vehTypeCode", plateSendSmsCodeBO.getVehTypeCode());
        String reqUrl = String.valueOf(plateSendSmsCodeBO.getReqCPFUrl() + "stpay/PlateSendSmsCode.do");
        JSONObject reqPara = JSONObject.fromObject(map);
        String response = HttpUtils.sendPost(reqUrl, reqPara.toString(), "UTF-8");
        JSONObject rspponse = JSONObject.fromObject(response);
        return GXJSONResult.ok(rspponse);
    }
}
