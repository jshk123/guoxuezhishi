package com.guoxuezhishi.controller.baiduapi;

import com.guoxuezhishi.utils.AudioUtils;
import com.guoxuezhishi.utils.GXJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jiang
 * @date: 2019/7/30
 */
@RestController
@Api(value = "MP3转PCM", tags = {"MP3转PCM"})
public class SpeakTranController {
    @PostMapping("/speakTran")
    @ApiOperation(value = "speakTran", notes = "speakTran")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mp3filepath", value = "输入文件", required = true, dataType = "String", paramType = "query", defaultValue = "output.mp3"),
            @ApiImplicitParam(name = "pcmfilepath", value = "输出文件", required = true, dataType = "String", paramType = "query", defaultValue = "output.pcm")
    })
    public GXJSONResult speakTran(String mp3filepath, String pcmfilepath) {
        AudioUtils utils = AudioUtils.getInstance();
        boolean flag = utils.convertMP32Pcm(mp3filepath, pcmfilepath);
        if (flag == false) {
            return GXJSONResult.errorMsg("音频转换异常！");
        }
        return GXJSONResult.ok();
    }

}
