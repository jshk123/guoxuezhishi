package com.guoxuezhishi.controller.baiduapi;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import com.guoxuezhishi.bean.BdApiBeanProp;
import com.guoxuezhishi.utils.GXJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author: jiang
 * @date: 2019/7/29
 */
@RestController
@Api(value = "百度语音合成", tags = {"百度语音合成"})
public class SpeakSynController {
    @Autowired
    private BdApiBeanProp bdApiBeanProp;

    @PostMapping("/speaksyn")
    @ApiOperation(value = "speakSyn", notes = "speakSyn")
    @ApiImplicitParam(name = "text", value = "想说的话", required = true, dataType = "String", paramType = "query")
    public GXJSONResult speakSyn(String text) {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(bdApiBeanProp.getAppIdYysb(), bdApiBeanProp.getApiKeyYysb(), bdApiBeanProp.getSecretKeyYysb());
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

/*        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理*/

/*        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");*/

        // 调用接口
        TtsResponse res = client.synthesis(text, "zh", 1, null);
        byte[] data = res.getData();
        JSONObject res1 = res.getResult();
        if (data != null) {
            try {
                Util.writeBytesToFileSystem(data, "output.mp3");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (res1 != null) {
            System.out.println(res1.toString(2));
        }
        return GXJSONResult.ok();
    }

}
