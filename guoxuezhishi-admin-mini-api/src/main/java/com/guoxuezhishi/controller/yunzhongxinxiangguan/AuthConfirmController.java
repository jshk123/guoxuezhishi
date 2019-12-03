package com.guoxuezhishi.controller.yunzhongxinxiangguan;

import com.guoxuezhishi.bean.MerchantBeanProp;
import com.guoxuezhishi.controller.BaseController;
import com.guoxuezhishi.pojo.yunzhongxinxiangguan.AuthConfirmBO;
import com.guoxuezhishi.utils.GXJSONResult;
import com.guoxuezhishi.utils.TimeUtil;
import com.guoxuezhishi.utils.YZXUtil;
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
 * @date: 2019/11/28
 */
@RestController
@Api(value = "PSAM卡授权确认", tags = {"PSAM卡授权确认"})
public class AuthConfirmController extends BaseController {
    @Autowired
    private MerchantBeanProp merchantBeanProp;
    @Autowired
    private YZXUtil yzxUtil;

    @PostMapping("/AuthConfirm")
    @ApiOperation(value = "AuthConfirm", notes = "AuthConfirm")
    public GXJSONResult eAccountOpen(@RequestBody AuthConfirmBO authConfirmBO) throws IOException {
        //签名
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("charset", merchantBeanProp.getCharset());
        map.put("version", merchantBeanProp.getVersion());
        map.put("signType", merchantBeanProp.getSignType());
        map.put("service", authConfirmBO.getService());
        map.put("requestTime", TimeUtil.getdate());
        map.put("merchantId", merchantBeanProp.getMerchantIdYun());
        map.put("subMerchantId", authConfirmBO.getSubMerchantId());
        map.put("psamNo", authConfirmBO.getPsamNo());
        map.put("listNo", authConfirmBO.getListNo());
        map.put("result", authConfirmBO.getResult());
        map.put("resultCode", authConfirmBO.getResultCode());
        for (Map.Entry<String, Object> key : map.entrySet()) {
            logger.info(key.getKey() + " : " + key.getValue());
        }

        String result = yzxUtil.postResult(map, authConfirmBO.getReqCPFUrl());
        JSONObject rspponse = JSONObject.fromObject(result);
        return GXJSONResult.ok(rspponse);
    }

}
