package com.guoxuezhishi.controller.eaccount;

import com.guoxuezhishi.pojo.eaccount.EAccountQueryIsOpenBO;
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
@Api(value = "工行二类户查询是否开户", tags = {"工行二类户查询是否开户"})
public class EAccountQueryIsOpenController {
    @PostMapping("/EAccountQueryIsOpen")
    @ApiOperation(value = "EAccountQueryIsOpen", notes = "EAccountQueryIsOpen")
    public GXJSONResult eAccountQueryIsOpen(@RequestBody EAccountQueryIsOpenBO eAccountQueryIsOpenBO) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("version", eAccountQueryIsOpenBO.getVersion());
        map.put("requestTime", eAccountQueryIsOpenBO.getRequestTime());
        map.put("bussId", eAccountQueryIsOpenBO.getBussId());
        map.put("certNo", eAccountQueryIsOpenBO.getCertNo());
        map.put("name", eAccountQueryIsOpenBO.getName());
        String reqUrl = String.valueOf(eAccountQueryIsOpenBO.getReqCPFUrl() + "stpay/EAccountQueryIsOpen.do");
        JSONObject reqPara = JSONObject.fromObject(map);
        String response = HttpUtils.sendPost(reqUrl, reqPara.toString(), "UTF-8");
        return GXJSONResult.ok(response);

    }
}
