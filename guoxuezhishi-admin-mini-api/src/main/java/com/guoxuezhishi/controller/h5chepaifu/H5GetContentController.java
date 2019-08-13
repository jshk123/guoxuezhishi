package com.guoxuezhishi.controller.h5chepaifu;

import com.guoxuezhishi.pojo.h5chepaifu.H5GetContentBO;
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
@Api(value = "车牌付获取文案", tags = {"车牌付获取文案"})
public class H5GetContentController {
    @PostMapping("/H5GetContent")
    @ApiOperation(value = "H5GetContent", notes = "H5GetContent")
    public GXJSONResult h5GetContent(@RequestBody H5GetContentBO h5GetContentBO) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("contentId", h5GetContentBO.getContentId());
        String reqUrl = String.valueOf(h5GetContentBO.getReqCPFUrl() + "stpay/H5GetContent.do");
        JSONObject reqPara = JSONObject.fromObject(map);
        String response = HttpUtils.sendPost(reqUrl, reqPara.toString(), "UTF-8");
        JSONObject rspponse = JSONObject.fromObject(response);
        return GXJSONResult.ok(rspponse);
    }
}
