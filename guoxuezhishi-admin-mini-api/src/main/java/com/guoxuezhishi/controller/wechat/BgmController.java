package com.guoxuezhishi.controller.wechat;

import com.guoxuezhishi.service.BgmService;
import com.guoxuezhishi.utils.GXJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api(value = "背景音乐业务接口",tags = "背景音乐业务接口")
@RequestMapping("/bgm")
public class BgmController extends BasicController {
    @Autowired
    private BgmService bgmService;

    @PostMapping("/list")
    @ApiOperation(value = "背景音乐业务接口", notes = "背景音乐业务接口")
    public GXJSONResult bgm() throws Exception {

        return GXJSONResult.ok(bgmService.queryBgmList());
    }

}
