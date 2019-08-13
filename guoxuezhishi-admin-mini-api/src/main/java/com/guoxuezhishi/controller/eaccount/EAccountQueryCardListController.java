package com.guoxuezhishi.controller.eaccount;

import com.guoxuezhishi.pojo.eaccount.EAccountQueryCardListBO;
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
@Api(value = "工行二类户查询卡列表", tags = {"工行二类户查询卡列表"})
public class EAccountQueryCardListController {
    @PostMapping("/EAccountQueryCardList")
    @ApiOperation(value = "EAccountQueryCardList", notes = "EAccountQueryCardList")
    public GXJSONResult eAccountQueryCardList(@RequestBody EAccountQueryCardListBO eAccountQueryCardListBO) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("version", eAccountQueryCardListBO.getVersion());
        map.put("requestTime", eAccountQueryCardListBO.getRequestTime());
        map.put("bussId", eAccountQueryCardListBO.getBussId());
        map.put("sCardNo", eAccountQueryCardListBO.getsCardNo());
        String reqUrl = String.valueOf(eAccountQueryCardListBO.getReqCPFUrl() + "stpay/EAccountQueryCardList.do");
        JSONObject reqPara = JSONObject.fromObject(map);
        String response = HttpUtils.sendPost(reqUrl, reqPara.toString(), "UTF-8");
        return GXJSONResult.ok(response);

    }
}
