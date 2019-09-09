package com.guoxuezhishi.controller.gaosuapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.guoxuezhishi.bean.GaoSuApiBeanProp;
import com.guoxuezhishi.controller.BaseController;
import com.guoxuezhishi.pojo.gaosuapi.HighWayCodePayBO;
import com.guoxuezhishi.utils.GXJSONResult;
import com.guoxuezhishi.utils.HttpUtils;
import com.guoxuezhishi.utils.TimeUtil;
import com.murong.ecp.netpay.smt.SM2Utils;
import com.murong.ecp.netpay.smt.SM4Utils;
import com.murong.ecp.netpay.smt.Util;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author: jiang
 * @date: 2019/9/9
 */
@RestController
@Api(value = "高速扣费", tags = {"高速扣费"})
public class HighWayCodePayController extends BaseController {
    private final GaoSuApiBeanProp gaoSuApiBeanProp;

    @Autowired
    public HighWayCodePayController(GaoSuApiBeanProp gaoSuApiBeanProp) {
        this.gaoSuApiBeanProp = gaoSuApiBeanProp;
    }

    @PostMapping("/HighWayCodePay")
    public GXJSONResult highWayCodePay(@RequestBody HighWayCodePayBO highWayCodePayBO) {

        String sm2Key = gaoSuApiBeanProp.getSm2Key();
        String sm4Key = gaoSuApiBeanProp.getSm4Key();
        String platPublicKey = gaoSuApiBeanProp.getPlatPublicKey();
        String reqUrl = highWayCodePayBO.getReqCPFUrl() + gaoSuApiBeanProp.getHighwayCodePay();
        String deviceNo = gaoSuApiBeanProp.getDeviceNo();
        String mercId = deviceNo.substring(0, 4);
        logger.info("merc_id : " + mercId);
        String authCode = highWayCodePayBO.getAuthCode();
        // 将请求报文存入TreeMap中进行自动排序
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        String version = "1.0";
        map.put("deviceNo", deviceNo);
        map.put("vehplateNo", "京E12345");
        map.put("vehplateColorCode", "0");
        map.put("vehTypeCode", "1");
        map.put("orderAmt", highWayCodePayBO.getOrderAmt());
        map.put("orderNo", TimeUtil.getdate());
        map.put("requestTime", TimeUtil.getdate());

        logger.info("加密原文: " + authCode);
        // 加密
        String encryptData = "";
        // 根据SM4秘钥串进行原始报文加密
        try {
            encryptData = SM4Utils.encryptData_CBC(authCode, sm4Key, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
        }

       /* if (version.equals("2.0")) {
            map.put("authCode", encryptData);
        } else {
            map.put("authCode", authCode);
        }*/
        map.put("authCode", authCode);

        // 报文签名
        logger.info("加签原文" + map.toString());

        // 生成请求的加签原文
        String sourceData = createSignSource(map);
        map.put("version", version);
        logger.info("加签原文串" + sourceData);
        String signData = "";
        // 根据私钥信息、原始报文进行加签
        byte[] c = {};
        try {
            c = SM2Utils.sign(mercId.getBytes(), Util.hexToByte(sm2Key), sourceData.getBytes());
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
        signData = Util.getHexString(c);
        map.put("merchantMac", signData);

        // 将请求报文转为json
        JSONObject itemJSONObj = JSONObject.parseObject(JSON.toJSONString(map));
        logger.info("请求报文" + itemJSONObj.toString());

        // HTTP发送请求
        String rspString = HttpUtils.sendPost(reqUrl, itemJSONObj.toString(), "UTF-8");
        logger.info("响应报文" + rspString);
        JSONObject rspJSONObj = JSONObject.parseObject(rspString);
        // 响应报文进行验签
        LinkedHashMap<String, String> rspMap = new LinkedHashMap<String, String>();
        rspMap.put("deviceNo", rspJSONObj.get("deviceNo").toString());
        rspMap.put("returnCode", rspJSONObj.get("returnCode").toString());
        rspMap.put("orderNo", rspJSONObj.get("orderNo").toString());
        if ("000000".equals(rspJSONObj.get("returnCode").toString())) {
            rspMap.put("paymentTime", rspJSONObj.get("paymentTime").toString());
            rspMap.put("payType", rspJSONObj.get("payType").toString());
        }

        /*if (version.equals("2.0")) {
            String sercertMac = rspJSONObj.get("serverMac").toString();
            logger.info("响应验签报文" + rspMap.toString());
            // 组装响应验签签名串原文
            String rspSignData = createSignSource(rspMap);
            rspMap.put("version", rspJSONObj.get("version").toString());
            logger.info("响应加签原文" + rspSignData);
            // 调用SM2方法进行公钥验签
            boolean verifyFlag = false;
            try {
                verifyFlag = SM2Utils.verifySign(mercId.getBytes(), Util.hexToByte(platPublicKey),
                        rspSignData.getBytes(), Util.hexToByte(sercertMac));
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!verifyFlag) {
                logger.info("验签失败");
            } else {
                logger.info("验签成功");
            }
        }*/
        JSONObject rspSponse = JSONObject.parseObject(String.valueOf(rspMap));
        return GXJSONResult.ok(rspSponse);
    }

    private String createSignSource(LinkedHashMap<String, String> sourceMap) {
        StringBuilder signsource = new StringBuilder();
        Set<String> set = sourceMap.keySet();
        int i = 0;
        for (String s : set) {
            i++;
            if (sourceMap.get(s) != null && sourceMap.get(s).trim().length() > 0) {
                if (i != 1) {
                    signsource.append("&");
                }
                signsource.append(sourceMap.get(s));
            }
        }
        return signsource.toString();
    }

}
