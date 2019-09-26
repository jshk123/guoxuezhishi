package com.guoxuezhishi.controller.yunzhongxin;

import com.guoxuezhishi.bean.MerchantBeanProp;
import com.guoxuezhishi.pojo.yunzhongxin.PlatePayInfoQueryBO;
import com.guoxuezhishi.pojo.yunzhongxin.PlatePaySendSmsCodeBO;
import com.guoxuezhishi.utils.CPFUtil;
import com.guoxuezhishi.utils.GXJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: jiang
 * @date: 2019/8/27
 */
@RestController
@Api(value = "云中心车牌发行状态查询", tags = "云中心车牌发行状态查询")
public class PlatePayInfoQueryController {
    @Autowired
    private MerchantBeanProp merchantBeanProp;
    @Autowired
    private CPFUtil cpfUtil;
    @PostMapping("/PlatePayInfoQuery")
    @ApiOperation(value = "PlatePayInfoQuery", notes = "PlatePayInfoQuery")
    public GXJSONResult platePayInfoQuery(@RequestBody PlatePayInfoQueryBO platePayInfoQueryBO) throws IOException {
        //签名
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("charset", merchantBeanProp.getCharset());
        map.put("version", merchantBeanProp.getVersion());
        map.put("signType", merchantBeanProp.getSignType());
        map.put("service", platePayInfoQueryBO.getService());
        map.put("merchantId", merchantBeanProp.getMerchantId());
        map.put("plateNo", platePayInfoQueryBO.getPlateNo());
        map.put("vehplateColor", platePayInfoQueryBO.getVehplateColor());
        map.put("vehTypeCode", platePayInfoQueryBO.getVehTypeCode());
        map.put("mblNo", platePayInfoQueryBO.getMblNo());
        map.put("checkNo", platePayInfoQueryBO.getCheckNo());
        String result = cpfUtil.postResult(map,platePayInfoQueryBO.getReqCPFUrl());
        JSONObject rspponse = JSONObject.fromObject(result);
        return GXJSONResult.ok(rspponse);
    }
}

