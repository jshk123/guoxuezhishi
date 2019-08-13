package com.guoxuezhishi.controller.eaccount;

import com.guoxuezhishi.pojo.eaccount.EAccountOpenBO;
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
 * @date: 2019/7/1
 */
@RestController
@Api(value = "工行二类户开户申请", tags = {"工行二类户开户申请"})
public class EAccountOpenController {
    @PostMapping(value = "/EAccountOpen", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "EAccountOpen", notes = "EAccountOpen")
    public GXJSONResult eAccountOpen(@RequestBody EAccountOpenBO eAccountOpenBO) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("version", eAccountOpenBO.getVersion());
        map.put("requestTime", eAccountOpenBO.getRequestTime());
        map.put("bussId", eAccountOpenBO.getBussId());
        map.put("outOrderNo", eAccountOpenBO.getOutOrderNo());
        map.put("jrnNo", eAccountOpenBO.getOutJrnNo());
        map.put("cardNo", eAccountOpenBO.getCardNo());
        map.put("name", eAccountOpenBO.getName());
        map.put("certType", eAccountOpenBO.getCertType());
        map.put("certNo", eAccountOpenBO.getCertNo());
        map.put("mobileNo", eAccountOpenBO.getMobileNo());
        map.put("period", eAccountOpenBO.getPeriod());
        map.put("pictureFront", eAccountOpenBO.getPictureFront());
        map.put("pictureBehind", eAccountOpenBO.getPictureBehind());
        map.put("occupation", eAccountOpenBO.getOccupation());
        map.put("address", eAccountOpenBO.getAddress());
        String reqUrl = String.valueOf(eAccountOpenBO.getReqCPFUrl() + "stpay/EAccountOpen.do");
        JSONObject reqPara = JSONObject.fromObject(map);
        System.out.println(map.toString());
        String response = HttpUtils.sendPost(reqUrl, reqPara.toString(), "UTF-8");
        JSONObject rspponse = JSONObject.fromObject(response);
        return GXJSONResult.ok(rspponse);
    }
}
