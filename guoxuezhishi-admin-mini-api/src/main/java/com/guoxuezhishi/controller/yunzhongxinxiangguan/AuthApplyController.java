package com.guoxuezhishi.controller.yunzhongxinxiangguan;

import com.guoxuezhishi.bean.MerchantBeanProp;
import com.guoxuezhishi.controller.BaseController;
import com.guoxuezhishi.pojo.yunzhongxinxiangguan.AuthApplyBO;
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
@Api(value = "PSAM卡授权申请", tags = {"PSAM卡授权申请"})
public class AuthApplyController extends BaseController {
    @Autowired
    private MerchantBeanProp merchantBeanProp;
    @Autowired
    private YZXUtil yzxUtil;

    @PostMapping("/AuthApply")
    @ApiOperation(value = "AuthApply", notes = "AuthApply")
    public GXJSONResult eAccountOpen(@RequestBody AuthApplyBO authApplyBO) throws IOException {
        //签名
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("charset", merchantBeanProp.getCharset());
        map.put("version", merchantBeanProp.getVersion());
        map.put("signType", merchantBeanProp.getSignType());
        map.put("service", authApplyBO.getService());
        map.put("requestTime", TimeUtil.getdate());
        map.put("merchantId", merchantBeanProp.getMerchantIdYun());
        map.put("subMerchantId", authApplyBO.getSubMerchantId());
        map.put("psamNo", authApplyBO.getPsamNo());
        map.put("psamVersion", authApplyBO.getPsamVersion());
        map.put("random", authApplyBO.getRandom());
        map.put("terminalTime", authApplyBO.getTerminalTime());
        for (Map.Entry<String, Object> key : map.entrySet()) {
            logger.info(key.getKey() + " : " + key.getValue());
        }

        String result = yzxUtil.postResult(map, authApplyBO.getReqCPFUrl());
        JSONObject rspponse = JSONObject.fromObject(result);
        return GXJSONResult.ok(rspponse);
    }

}
