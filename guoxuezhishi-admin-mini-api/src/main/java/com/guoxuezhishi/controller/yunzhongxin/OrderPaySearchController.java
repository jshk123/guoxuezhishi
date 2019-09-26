package com.guoxuezhishi.controller.yunzhongxin;

import com.guoxuezhishi.bean.MerchantBeanProp;
import com.guoxuezhishi.pojo.yunzhongxin.OrderPaySearchBO;
import com.guoxuezhishi.utils.CPFUtil;
import com.guoxuezhishi.utils.GXJSONResult;
import com.guoxuezhishi.utils.TimeUtil;
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
 * @date: 2019/7/3
 */
@RestController
@Api(value = "车牌付查看订单结果", tags = {"车牌付查看订单结果"})
public class OrderPaySearchController {
    @Autowired
    private MerchantBeanProp merchantBeanProp;
    @Autowired
    private CPFUtil cpfUtil;

    @PostMapping("/OrderPaySearch")
    @ApiOperation(value = "OrderPaySearch", notes = "OrderPaySearch")
    public GXJSONResult eAccountOpen(@RequestBody OrderPaySearchBO orderPaySearchBO) throws IOException {
        //签名
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("charset", merchantBeanProp.getCharset());
        map.put("version", merchantBeanProp.getVersion());
        map.put("signType", merchantBeanProp.getSignType());
        map.put("service", orderPaySearchBO.getService());
        map.put("requestTime", TimeUtil.getdate());
        map.put("merchantId", merchantBeanProp.getMerchantId());
        map.put("channelType", orderPaySearchBO.getChannelType());
        map.put("txnType", orderPaySearchBO.getTxnType());
        map.put("busType", orderPaySearchBO.getBusType());
        map.put("orderNo", orderPaySearchBO.getOrderNo());
        map.put("rmk", orderPaySearchBO.getRmk());
        String result = cpfUtil.postResult(map,orderPaySearchBO.getReqCPFUrl());
        JSONObject rspponse = JSONObject.fromObject(result);
        return GXJSONResult.ok(rspponse);
    }

}
