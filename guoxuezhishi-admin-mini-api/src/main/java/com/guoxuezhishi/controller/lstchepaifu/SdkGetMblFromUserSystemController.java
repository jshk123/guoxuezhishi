package com.guoxuezhishi.controller.lstchepaifu;

import com.guoxuezhishi.pojo.lstchepaifu.SdkGetMblFromUserSystemBO;
import com.guoxuezhishi.utils.GXJSONResult;
import com.guoxuezhishi.utils.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: jiang
 * @date: 2019/8/14
 */
@RestController
@Api(value = "获取用户手机号", tags = {"获取用户手机号"})
public class SdkGetMblFromUserSystemController {
    @Autowired
    private static Logger logger = Logger.getLogger(SpringBootApplication.class);

    @PostMapping("/SdkGetMblFromUserSystem")
    @ApiOperation(value = "获取用户手机号", notes = "获取用户手机号")
    public GXJSONResult sdkGetMblFromUserSystem(@RequestBody SdkGetMblFromUserSystemBO sdkGetMblFromUserSystemBO) throws Exception {
        Map<String, Object> map = new LinkedHashMap<String, Object>();

        map.put("plat", sdkGetMblFromUserSystemBO.getPlat());
        map.put("channel", sdkGetMblFromUserSystemBO.getChannel());
        map.put("contentTyp", sdkGetMblFromUserSystemBO.getContentTyp());
        map.put("deviceMod", sdkGetMblFromUserSystemBO.getDeviceMod());
        map.put("deviceID", sdkGetMblFromUserSystemBO.getDeviceID());
        map.put("opSys", sdkGetMblFromUserSystemBO.getOpSys());
        map.put("opSysVer", sdkGetMblFromUserSystemBO.getOpSysVer());
        map.put("networkTyp", sdkGetMblFromUserSystemBO.getNetworkTyp());
        map.put("netServiceMer", sdkGetMblFromUserSystemBO.getNetServiceMer());
        map.put("ipAddress", sdkGetMblFromUserSystemBO.getIpAddress());
        map.put("deviceLanguage", sdkGetMblFromUserSystemBO.getDeviceLanguage());
        map.put("clientVer", sdkGetMblFromUserSystemBO.getClientVer());
        map.put("characterSet", sdkGetMblFromUserSystemBO.getCharacterSet());
        map.put("locationData", sdkGetMblFromUserSystemBO.getLocationData());
        map.put("customId", sdkGetMblFromUserSystemBO.getCustomId());
        map.put("regTyp", sdkGetMblFromUserSystemBO.getRegTyp());
//        map.put("enc_flag", "1");
        String reqUrl = String.valueOf(sdkGetMblFromUserSystemBO.getReqCPFUrl() + "mca/stpay/SdkGetMblFromUserSystem.xhtml");
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
