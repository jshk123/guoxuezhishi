package com.guoxuezhishi.controller.duijieyunzhongxin;

import com.guoxuezhishi.bean.MerchantBeanProp;
import com.guoxuezhishi.controller.BaseController;
import com.guoxuezhishi.pojo.duijieyunzhongxin.PlatePayMethodQueryBO;
import com.guoxuezhishi.utils.CPFUtil;
import com.guoxuezhishi.utils.GXJSONResult;
import com.guoxuezhishi.utils.RSASignUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: jiang
 * @date: 2019/8/27
 */
@RestController
@Api(value = "车牌付功能是否可用", tags = "车牌付功能是否可用")
public class PlatePayMethodQueryController extends BaseController {
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
        String result = cpfUtil.postResult(map, platePayMethodQueryBO.getReqCPFUrl());
        JSONObject rspponse = JSONObject.fromObject(result);
        //验签charset|version|signType|service|merchantId|returnCode|returnMsg|limit|lastModTime|
        Map<String, String> retMap = new LinkedHashMap<String, String>();
        retMap.put("charset", rspponse.getString("charset"));
        retMap.put("version", rspponse.getString("version"));
        retMap.put("signType", rspponse.getString("signType"));
        retMap.put("service", rspponse.getString("service"));
        logger.info("service:" + rspponse.getString("service"));
        retMap.put("merchantId", rspponse.getString("merchantId"));
        retMap.put("returnCode", rspponse.getString("returnCode"));
        retMap.put("returnMsg", rspponse.getString("returnMsg"));
        retMap.put("limit", rspponse.getString("limit"));
        retMap.put("lastModTime", rspponse.getString("lastModTime"));
        Map responseMap = new HashMap();
        responseMap.putAll(retMap);
        Set set1 = retMap.keySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            String key0 = (String) iterator1.next();
            String tmp = retMap.get(key0);
            if (StringUtils.equals(tmp, "null") || StringUtils.isBlank(tmp)) {
                responseMap.remove(key0);
            }
        }
        String sf = RSASignUtil.coverMap2String(responseMap);
        boolean flag = false;
        RSASignUtil util = new RSASignUtil(merchantBeanProp.getRootCertPath());
        logger.info("serverSign:" + rspponse.getString("serverSign"));
        flag = util.verify(sf, rspponse.getString("serverSign"), rspponse.getString("serverCert"), "GBK");
        logger.info("flag:" + flag);
        if (!flag) {
            logger.info("返回验签报文：" + result);
            return GXJSONResult.errorMsg("验签错误");
        }
        return GXJSONResult.ok(rspponse);
    }
}
