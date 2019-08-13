package com.guoxuezhishi.controller.baiduapi;

import com.baidu.aip.speech.AipSpeech;
import com.guoxuezhishi.bean.BdApiBeanProp;
import com.guoxuezhishi.utils.GXJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jiang
 * @date: 2019/7/29
 */
@RestController
@Api(value = "百度语音识别", tags = {"百度语音识别"})
public class SpeakRecController {
    @Autowired
    private BdApiBeanProp bdApiBeanProp;

    @PostMapping("/speakRec")
    @ApiOperation(value = "speakRec", notes = "speakRec")
    @ApiImplicitParam(name = "path", value = "pcm路径", required = true, dataType = "String", paramType = "query", defaultValue = "output.pcm")
    public GXJSONResult speakRec(String path) {
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
        // 对本地语音文件进行识别
        JSONObject asrRes = client.asr(path, "pcm", 16000, null);
        System.out.println("JSONObject：" + asrRes);
        com.alibaba.fastjson.JSONObject fastJson = com.alibaba.fastjson.JSONObject.parseObject(asrRes.toString());
        System.out.println("fastJson：" + fastJson);
/*        // 对语音二进制数据进行识别
        byte[] data = Util.readFileByBytes(path);     //readFileByBytes仅为获取二进制数据示例
        JSONObject asrRes2 = client.asr(data, "pcm", 16000, null);
        System.out.println(asrRes2);*/

        return GXJSONResult.ok(fastJson);
    }

}
