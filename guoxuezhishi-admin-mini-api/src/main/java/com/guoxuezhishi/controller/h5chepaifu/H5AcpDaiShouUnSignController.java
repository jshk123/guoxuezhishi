package com.guoxuezhishi.controller.h5chepaifu;

import com.guoxuezhishi.pojo.h5chepaifu.H5AcpDaiShouUnSignBO;
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
@Api(value = "车牌付代付解约", tags = {"车牌付代付解约"})
public class H5AcpDaiShouUnSignController {
    @PostMapping("/H5AcpDaiShouUnSign")
    @ApiOperation(value = "H5AcpDaiShouUnSign", notes = "H5AcpDaiShouUnSign")
    public GXJSONResult h5GetContent(@RequestBody H5AcpDaiShouUnSignBO h5AcpDaiShouUnSignBO) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("charset", h5AcpDaiShouUnSignBO.getCharset());
        map.put("version", h5AcpDaiShouUnSignBO.getVersion());
        map.put("service", h5AcpDaiShouUnSignBO.getService());
        map.put("requestTime", h5AcpDaiShouUnSignBO.getRequestTime());
        map.put("customerId", h5AcpDaiShouUnSignBO.getCustomerId());
        map.put("agrNo", h5AcpDaiShouUnSignBO.getAgrNo());
        String reqUrl = String.valueOf(h5AcpDaiShouUnSignBO.getReqCPFUrl() + "stpay/H5AcpDaiShouUnSign.do");
        JSONObject reqPara = JSONObject.fromObject(map);
        String response = HttpUtils.sendPost(reqUrl, reqPara.toString(), "UTF-8");
        JSONObject rspponse = JSONObject.fromObject(response);
        return GXJSONResult.ok(rspponse);
    }
}
