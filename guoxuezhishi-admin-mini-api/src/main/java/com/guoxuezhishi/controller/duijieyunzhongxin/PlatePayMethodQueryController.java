package com.guoxuezhishi.controller.duijieyunzhongxin;

import com.guoxuezhishi.bean.MerchantBeanProp;
import com.guoxuezhishi.pojo.duijieyunzhongxin.PlatePayMethodQueryBO;
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
@Api(value = "车牌付功能是否可用", tags = "车牌付功能是否可用")
public class PlatePayMethodQueryController {
    @Autowired
    private MerchantBeanProp merchantBeanProp;
    @Autowired
    private CPFUtil cpfUtil;

    @PostMapping("/PlatePayMethodQuery")
    @ApiOperation(value = "PlatePayMethodQuery", notes = "PlatePayMethodQuery")
    public GXJSONResult platePayMethodQuery(@RequestBody PlatePayMethodQueryBO platePayMethodQueryBO) throws IOException {
        //签名
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("charset", merchantBeanProp.getCharset());
        map.put("version", merchantBeanProp.getVersion());
        map.put("signType", merchantBeanProp.getSignType());
        map.put("service", platePayMethodQueryBO.getService());
        map.put("merchantId", merchantBeanProp.getMerchantId());
        map.put("plateNo", platePayMethodQueryBO.getPlateNo());
        map.put("plateColorCode", platePayMethodQueryBO.getPlateColorCode());
        map.put("vehTypeCode", platePayMethodQueryBO.getVehTypeCode());
        String result = cpfUtil.postResult(map,platePayMethodQueryBO.getReqCPFUrl());
        JSONObject rspponse = JSONObject.fromObject(result);
        return GXJSONResult.ok(rspponse);
    }
}
