package com.guoxuezhishi.controller.bjfhapi;

import com.guoxuezhishi.bean.BjfhApiBeanProp;
import com.guoxuezhishi.pojo.bjfhapi.restapi.BjfhApiRestApiRequest;
import com.guoxuezhishi.pojo.bjfhapi.restapi.BjfhApiRestApiResponse;
import com.icbc.api.DefaultIcbcClient;
import com.icbc.api.IcbcApiException;
import com.icbc.api.IcbcConstants;
import com.icbc.api.internal.apache.http.HttpHost;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

/**
 * @author: jiang
 * @date: 2019/7/8
 */
public class BjfhUtil {
    @Autowired
    private static Logger logger = Logger.getLogger(SpringBootApplication.class);

    /**
     * 请求工行二类户通用接口
     */
    public static BjfhApiRestApiResponse BjfhResponsse(BjfhApiRestApiRequest request ,BjfhApiBeanProp bjfhApiBeanProp) throws IcbcApiException {

        //生成msgId，保证app级唯一。此种方案只做示例
        UUID uuid = UUID.randomUUID();
        String msgId = uuid.toString();
        logger.info("bjfhApiBeanProp.getAppId---" + bjfhApiBeanProp.getAppId());

        DefaultIcbcClient client = new DefaultIcbcClient(bjfhApiBeanProp.getAppId(),
                IcbcConstants.SIGN_TYPE_RSA,
                bjfhApiBeanProp.getMyPrivateKey(),
                IcbcConstants.CHARSET_UTF8,
                IcbcConstants.FORMAT_JSON,
                bjfhApiBeanProp.getApigwPublickKey(),
                IcbcConstants.ENCRYPT_TYPE_AES,
                bjfhApiBeanProp.getAesKey(),
                null,
                null
        );
        //指定代理ip和端口
        HttpHost proxy = new HttpHost(bjfhApiBeanProp.getProxyIp(), Integer.parseInt(bjfhApiBeanProp.getProxyPort()));
        client.setProxy(proxy);
        BjfhApiRestApiResponse response = client.execute(request, msgId);
        return response;

    }
}
