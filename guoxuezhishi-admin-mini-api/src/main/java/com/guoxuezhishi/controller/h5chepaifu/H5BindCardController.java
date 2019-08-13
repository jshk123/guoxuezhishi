package com.guoxuezhishi.controller.h5chepaifu;

import com.guoxuezhishi.pojo.h5chepaifu.H5BindCardBO;
import com.guoxuezhishi.utils.GXJSONResult;
import com.guoxuezhishi.utils.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: jiang
 * @date: 2019/7/2
 */
@RestController
@Api(value = "车牌付代付绑卡", tags = {"车牌付代付绑卡"})
public class H5BindCardController {
    @PostMapping("/H5BindCard")
    @ApiOperation(value = "H5BindCard", notes = "H5BindCard")
    public GXJSONResult h5GetContent(@RequestBody H5BindCardBO h5BindCardBO) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("customerId", h5BindCardBO.getCustomerId());
        map.put("name", h5BindCardBO.getName());
        map.put("cardNo", h5BindCardBO.getCardNo());
        map.put("accType", h5BindCardBO.getAccType());
        map.put("capCorg", h5BindCardBO.getCapCorg());
        map.put("idType", h5BindCardBO.getIdType());
        map.put("idNo", h5BindCardBO.getIdNo());
        map.put("cvn2", h5BindCardBO.getCvn2());
        map.put("expDate", h5BindCardBO.getExpDate());
        map.put("mblNo", h5BindCardBO.getMblNo());
        map.put("smsCode", h5BindCardBO.getSmsCode());
        map.put("plateNo", h5BindCardBO.getPlateNo());
        map.put("vehplateColor", h5BindCardBO.getVehplateColor());
        map.put("vehTypeCode", h5BindCardBO.getVehTypeCode());
        map.put("token", h5BindCardBO.getToken());
        map.put("h5MblNo", h5BindCardBO.getH5MblNo());
        map.put("reqType", h5BindCardBO.getReqType());
        String reqUrl = String.valueOf(h5BindCardBO.getReqCPFUrl() + "stpay/H5BindCard.do");
        JSONObject reqPara = JSONObject.fromObject(map);
        String response = HttpUtils.sendPost(reqUrl, reqPara.toString(), "UTF-8");
        JSONObject rspponse = JSONObject.fromObject(response);
        return GXJSONResult.ok(rspponse);
    }
}
