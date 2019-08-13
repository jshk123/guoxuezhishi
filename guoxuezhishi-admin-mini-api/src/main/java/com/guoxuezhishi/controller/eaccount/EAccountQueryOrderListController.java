package com.guoxuezhishi.controller.eaccount;

import com.guoxuezhishi.pojo.eaccount.EAccountQueryOrderListBO;
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
@Api(value = "工行二类户查询交易列表", tags = {"工行二类户查询交易列表"})
public class EAccountQueryOrderListController {
    @PostMapping("/EAccountQueryOrderList")
    @ApiOperation(value = "EAccountQueryOrderList", notes = "EAccountQueryOrderList")
    public GXJSONResult eAccountQueryOrderList(@RequestBody EAccountQueryOrderListBO eAccountQueryOrderListBO) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("version", eAccountQueryOrderListBO.getVersion());
        map.put("requestTime", eAccountQueryOrderListBO.getRequestTime());
        map.put("bussId", eAccountQueryOrderListBO.getBussId());
        map.put("sCardNo", eAccountQueryOrderListBO.getsCardNo());
        map.put("type", eAccountQueryOrderListBO.getType());
        map.put("startDate", eAccountQueryOrderListBO.getStartDate());
        map.put("endDate", eAccountQueryOrderListBO.getEndDate());
        String reqUrl = String.valueOf(eAccountQueryOrderListBO.getReqCPFUrl() + "stpay/EAccountQueryOrderList.do");
        JSONObject reqPara = JSONObject.fromObject(map);
        String response = HttpUtils.sendPost(reqUrl, reqPara.toString(), "UTF-8");
        return GXJSONResult.ok(response);

    }
}
