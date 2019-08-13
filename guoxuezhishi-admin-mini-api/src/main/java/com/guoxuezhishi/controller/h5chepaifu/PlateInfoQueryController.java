package com.guoxuezhishi.controller.h5chepaifu;

import com.guoxuezhishi.pojo.h5chepaifu.PlateInfoQueryBO;
import com.guoxuezhishi.utils.GXJSONResult;
import com.guoxuezhishi.utils.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: jiang
 * @date: 2019/8/7
 */
@RestController
@Api(value = "查询无感支付状态", tags = "查询无感支付状态")
public class PlateInfoQueryController {
    @PostMapping("/PlateInfoQuery")
    @ApiImplicitParam
    public GXJSONResult plateInfoQuery(@RequestBody PlateInfoQueryBO plateInfoQueryBO) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("charset", plateInfoQueryBO.getCharset());
        map.put("version", plateInfoQueryBO.getVersion());
        map.put("service", plateInfoQueryBO.getService());
        map.put("requestTime", plateInfoQueryBO.getRequestTime());
        map.put("plateNo", plateInfoQueryBO.getPlateNo());
        map.put("cardNo", plateInfoQueryBO.getCardNo());
        map.put("mblNo", plateInfoQueryBO.getMblNo());
        map.put("checkNo", plateInfoQueryBO.getCheckNo());
        map.put("vehplateColor", plateInfoQueryBO.getVehplateColor());
        map.put("vehTypeCode", plateInfoQueryBO.getVehTypeCode());
//        map.put("customerId", plateInfoQueryBO.getCustomerId());
        String reqUrl = String.valueOf(plateInfoQueryBO.getReqCPFUrl() + "stpay/PlateInfoQuery.do");
        JSONObject reqPara = JSONObject.fromObject(map);
        String response = HttpUtils.sendPost(reqUrl, reqPara.toString(), "UTF-8");
        JSONObject rspponse = JSONObject.fromObject(response);
        return GXJSONResult.ok(rspponse);
    }

}
