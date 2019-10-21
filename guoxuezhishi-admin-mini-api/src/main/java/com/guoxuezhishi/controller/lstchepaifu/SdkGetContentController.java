package com.guoxuezhishi.controller.lstchepaifu;

import com.guoxuezhishi.controller.BaseController;
import com.guoxuezhishi.pojo.lstchepaifu.SdkGetContentBO;
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
 * @date: 2019/10/11
 */
@RestController
@Api(value = "获取文案", tags = {"获取文案"})
public class SdkGetContentController extends BaseController {

    @PostMapping("/SdkGetContent")
    @ApiOperation(value = "获取文案", notes = "获取文案")
    public GXJSONResult sdkGetContent(@RequestBody SdkGetContentBO sdkGetContentBO) throws Exception {
        Map<String, Object> map = new LinkedHashMap<String, Object>();

        map.put("plat", sdkGetContentBO.getPlat());
        map.put("channel", sdkGetContentBO.getChannel());
        map.put("contentTyp", sdkGetContentBO.getContentTyp());
        map.put("deviceMod", sdkGetContentBO.getDeviceMod());
        map.put("deviceID", sdkGetContentBO.getDeviceID());
        map.put("opSys", sdkGetContentBO.getOpSys());
        map.put("opSysVer", sdkGetContentBO.getOpSysVer());
        map.put("networkTyp", sdkGetContentBO.getNetworkTyp());
        map.put("netServiceMer", sdkGetContentBO.getNetServiceMer());
        map.put("ipAddress", sdkGetContentBO.getIpAddress());
        map.put("deviceLanguage", sdkGetContentBO.getDeviceLanguage());
        map.put("clientVer", sdkGetContentBO.getClientVer());
        map.put("characterSet", sdkGetContentBO.getCharacterSet());
        map.put("locationData", sdkGetContentBO.getLocationData());
        map.put("contentId", sdkGetContentBO.getContentId());
//        map.put("enc_flag", "1");
        String reqUrl = String.valueOf(sdkGetContentBO.getReqCPFUrl() + "mca/stpay/SdkGetContent.xhtml");
        JSONObject reqPara = JSONObject.fromObject(map);
        String response = HttpUtils.sendPost(reqUrl, reqPara.toString(), "UTF-8");
        JSONObject rspponse = JSONObject.fromObject(response);
        logger.info("rspponse: " + rspponse);
        String t = rspponse.getString("t");
        String d = rspponse.getString("d");
        String v = null;
        if (rspponse.has("v")) {
            v = rspponse.getString("v");
        } else {
            v = "";
        }
        GetData getData = new GetData();
        String vdata = getData.getVdata(t, d, v);
        logger.info("vdata: " + vdata);
        JSONObject res = JSONObject.fromObject(vdata);
        logger.info("res: " + res);
        return GXJSONResult.ok(res);
    }
}
