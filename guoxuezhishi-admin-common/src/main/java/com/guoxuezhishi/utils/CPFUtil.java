package com.guoxuezhishi.utils;

import com.guoxuezhishi.bean.MerchantBeanProp;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @author: jiang
 * @date: 2019/7/4
 */
@Component
public class CPFUtil {
    @Autowired
    private static Logger logger = Logger.getLogger(SpringBootApplication.class);

    @Autowired
    private MerchantBeanProp merchantBeanProp;

    /**
     * H5加签认证
     */
    public String postResult(Map<String, Object> reqMap) throws IOException {
        //去除空值
        if (reqMap != null && !reqMap.isEmpty()) {
            for (Map.Entry<String, Object> entry : reqMap.entrySet()) {
                if (reqMap.get(entry) == null || reqMap.get(entry) == "") {
                    reqMap.remove(entry);
                }
            }
        }
        //编码设置
        String charset = merchantBeanProp.getCharset();
        String encoding = "";
        if ("00".equals(charset)) {
            encoding = "GBK";
        } else if ("01".equals(charset)) {
            encoding = "GB2312";
        } else if ("02".equals(charset)) {
            encoding = "UTF-8";
        } else {
            encoding = "GBK";
        }
        //加签准备
        String locationPath = ResourceUtils.getURL("classpath:").getPath();
        String merchantId = merchantBeanProp.getMerchantId();
        String merCert = merchantId + ".p12";
        String merchantCerPath = locationPath + merchantBeanProp.getMerchantCertPath() + merCert;
        logger.info("merchantCerPath:" + merchantCerPath);
        String merchantCertPass = merchantBeanProp.getMerchantCertPass();
        String requestUrl = merchantBeanProp.getRequestUrl();
        //加签
        RSASignUtil util = new RSASignUtil(merchantCerPath, merchantCertPass);
        String reqData = RSASignUtil.coverMap2String(reqMap);
        String merchantSign = util.sign(reqData, encoding);
        String merchantCert = util.getCertInfo();
        //-- 请求报文
        String buf = reqData + "&merchantSign=" + merchantSign + "&merchantCert=" + merchantCert;
        //发起http请求，并获取响应报文
        String res = MerchantUtil.sendAndRecv(requestUrl, buf.toString(), charset);
        logger.info("res: " + res);
        Map<String, String> restMap = RSASignUtil.coverString2Map(res);
        JSONObject restJson = JSONObject.fromObject(restMap);
        return restJson.toString();
    }

}
