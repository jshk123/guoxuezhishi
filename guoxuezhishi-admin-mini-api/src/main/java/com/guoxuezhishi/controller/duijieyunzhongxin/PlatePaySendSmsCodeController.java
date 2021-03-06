package com.guoxuezhishi.controller.duijieyunzhongxin;

import com.guoxuezhishi.bean.MerchantBeanProp;
import com.guoxuezhishi.pojo.duijieyunzhongxin.PlatePaySendSmsCodeBO;
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
@Api(value = "云中心车牌发送验证码", tags = "云中心车牌发送验证码")
public class PlatePaySendSmsCodeController {
    @Autowired
    private MerchantBeanProp merchantBeanProp;
    @Autowired
    private CPFUtil cpfUtil;
    @PostMapping("/PlatePaySendSmsCode")
    @ApiOperation(value = "PlatePaySendSmsCode", notes = "PlatePaySendSmsCode")
    public GXJSONResult platePaySendSmsCode(@RequestBody PlatePaySendSmsCodeBO platePaySendSmsCodeBO) throws IOException {
        //签名
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("charset", merchantBeanProp.getCharset());
        map.put("version", merchantBeanProp.getVersion());
        map.put("signType", merchantBeanProp.getSignType());
        map.put("service", platePaySendSmsCodeBO.getService());
        map.put("merchantId", merchantBeanProp.getMerchantId());
        map.put("plateNo", platePaySendSmsCodeBO.getPlateNo());
        map.put("vehplateColor", platePaySendSmsCodeBO.getVehplateColor());
        map.put("vehTypeCode", platePaySendSmsCodeBO.getVehTypeCode());
        map.put("mblNo", platePaySendSmsCodeBO.getMblNo());
        String result = cpfUtil.postResult(map,platePaySendSmsCodeBO.getReqCPFUrl());
        JSONObject rspponse = JSONObject.fromObject(result);
        return GXJSONResult.ok(rspponse);
    }
}
