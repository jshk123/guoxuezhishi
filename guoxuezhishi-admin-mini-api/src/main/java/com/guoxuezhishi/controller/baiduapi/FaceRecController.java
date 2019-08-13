package com.guoxuezhishi.controller.baiduapi;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.face.AipFace;
import com.guoxuezhishi.bean.BdApiBeanProp;
import com.guoxuezhishi.utils.GXJSONResult;
import com.guoxuezhishi.utils.ImageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author: jiang
 * @date: 2019/7/30
 */
@RestController
@Api(value = "百度人脸识别", tags = "百度人脸识别")
public class FaceRecController {
    @Autowired
    private BdApiBeanProp bdApiBeanProp;

    @PostMapping("/faceRec")
    @ApiOperation(value = "faceRec", notes = "faceRec")
    @ApiImplicitParam(name = "path", value = "pcm路径", required = true, dataType = "String", paramType = "query", defaultValue = "image.jpg")
    public GXJSONResult faceRec(String path) throws IOException {
        AipFace client = new AipFace(bdApiBeanProp.getAppIdRlsb(), bdApiBeanProp.getApiKeyRlsb(), bdApiBeanProp.getSecretKeyRlsb());
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

/*        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理*/

        //获取当前项目的根路径
        File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath();
        System.out.println(courseFile);
        // 调用接口
        String image = ImageUtils.ImageToBase64(path);
        String imageType = "BASE64";

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("face_field", "age,beauty");
        options.put("max_face_num", "2");
        options.put("face_type", "LIVE");
        options.put("liveness_control", "LOW");

        // 人脸检测
        JSONObject res = client.detect(image, imageType, options);
        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(res.toString());
        return GXJSONResult.ok(jsonObject);
    }
}
