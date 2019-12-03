package com.guoxuezhishi.controller.yunzhongxinxiangguan;

import com.guoxuezhishi.bean.MerchantBeanProp;
import com.guoxuezhishi.controller.BaseController;
import com.guoxuezhishi.pojo.yunzhongxinxiangguan.SignApplyBO;
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
@Api(value = "PSAM卡签到", tags = {"PSAM卡签到"})
public class SignApplyController extends BaseController {
    @Autowired
    private MerchantBeanProp merchantBeanProp;
    @Autowired
    private YZXUtil yzxUtil;

    @PostMapping("/SignApply")
    @ApiOperation(value = "SignApply", notes = "SignApply")
    public GXJSONResult eAccountOpen(@RequestBody SignApplyBO signApplyBO) throws IOException {
        //签名
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("charset", merchantBeanProp.getCharset());
        map.put("version", merchantBeanProp.getVersion());
        map.put("signType", merchantBeanProp.getSignType());
        map.put("service", signApplyBO.getService());
        map.put("requestTime", TimeUtil.getdate());
        map.put("merchantId", merchantBeanProp.getMerchantIdYun());
        map.put("subMerchantId", signApplyBO.getSubMerchantId());
        map.put("psamNo", signApplyBO.getPsamNo());
        map.put("terminalNo", signApplyBO.getTerminalNo());
        map.put("terminalTime", signApplyBO.getTerminalTime());
        for (Map.Entry<String, Object> key : map.entrySet()) {
            logger.info(key.getKey() + " : " + key.getValue());
        }

        String result = yzxUtil.postResult(map, signApplyBO.getReqCPFUrl());
        JSONObject rspponse = JSONObject.fromObject(result);
        return GXJSONResult.ok(rspponse);
    }

}
