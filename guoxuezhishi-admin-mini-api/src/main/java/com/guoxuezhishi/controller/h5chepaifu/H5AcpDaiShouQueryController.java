package com.guoxuezhishi.controller.h5chepaifu;

import com.guoxuezhishi.pojo.h5chepaifu.H5AcpDaiShouQueryBO;
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
@Api(value = "车牌付代付查询", tags = {"车牌付代付查询"})
public class H5AcpDaiShouQueryController {
    @PostMapping("/H5AcpDaiShouQuery")
    @ApiOperation(value = "车牌付代付查询", notes = "车牌付代付查询")
    public GXJSONResult h5AcpDaiShouQuery(@RequestBody H5AcpDaiShouQueryBO h5AcpDaiShouQueryBO) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("charset", h5AcpDaiShouQueryBO.getCharset());
        map.put("version", h5AcpDaiShouQueryBO.getVersion());
        map.put("service", h5AcpDaiShouQueryBO.getService());
        map.put("requestTime", h5AcpDaiShouQueryBO.getRequestTime());
        map.put("customerId", h5AcpDaiShouQueryBO.getCustomerId());
        String reqUrl = String.valueOf(h5AcpDaiShouQueryBO.getReqCPFUrl() + "stpay/H5AcpDaiShouQuery.do");
        JSONObject reqPara = JSONObject.fromObject(map);
        String response = HttpUtils.sendPost(reqUrl, reqPara.toString(), "UTF-8");
        JSONObject rspponse = JSONObject.fromObject(response);
        return GXJSONResult.ok(rspponse);
    }
}
