package com.guoxuezhishi.controller.yunzhongxin;

import com.guoxuezhishi.bean.MerchantBeanProp;
import com.guoxuezhishi.controller.BaseController;
import com.guoxuezhishi.pojo.yunzhongxin.LicensePlatePayBO;
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
 * @date: 2019/9/9
 */
@RestController
@Api(value = "车牌付扣款", tags = {"车牌付扣款"})
public class LicensePlatePayController extends BaseController {
    @Autowired
    private MerchantBeanProp merchantBeanProp;
    @Autowired
    private CPFUtil cpfUtil;

    @PostMapping("/LicensePlatePay")
    @ApiOperation(value = "LicensePlatePay", notes = "LicensePlatePay")
    public GXJSONResult eAccountOpen(@RequestBody LicensePlatePayBO licensePlatePayBO) throws IOException {
        //签名
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("charset", merchantBeanProp.getCharset());
        map.put("version", merchantBeanProp.getVersion());
        map.put("signType", merchantBeanProp.getSignType());
        map.put("service", licensePlatePayBO.getService());
        map.put("requestId", TimeUtil.getdate());
        map.put("merchantId", merchantBeanProp.getMerchantId());
        map.put("plateNo", licensePlatePayBO.getPlateNo());
        map.put("plateColorCode", licensePlatePayBO.getPlateColorCode());
        map.put("vehTypeCode", licensePlatePayBO.getVehTypeCode());
        map.put("payScene", licensePlatePayBO.getPayScene());
        map.put("orderNo", TimeUtil.getdate());
        map.put("orderTime", TimeUtil.getdate());
        map.put("ccy", licensePlatePayBO.getCcy());
        map.put("orderAmount", licensePlatePayBO.getOrderAmount());
        map.put("orderDesc", licensePlatePayBO.getOrderDesc());
        map.put("remark", licensePlatePayBO.getRemark());
        for (Map.Entry<String, Object> key : map.entrySet()) {
            logger.info(key.getKey() + " : " + key.getValue());
        }
        String result = cpfUtil.postResult(map);
        JSONObject rspponse = JSONObject.fromObject(result);
        return GXJSONResult.ok(rspponse);
    }

}
