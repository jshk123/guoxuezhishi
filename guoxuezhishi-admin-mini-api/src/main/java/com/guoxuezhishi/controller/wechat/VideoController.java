package com.guoxuezhishi.controller.wechat;

import com.guoxuezhishi.pojo.wechat.Bgm;
import com.guoxuezhishi.service.BgmService;
import com.guoxuezhishi.utils.GXJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@Api(value = "视频相关业务接口", tags = "视频相关业务接口")
@RequestMapping("/video")
public class VideoController extends BasicController {
    @Autowired
    private BgmService bgmService;

//    @Autowired
//    private VideoService videoService;

    @PostMapping(value = "/upload", headers = "content-type=multipart/form-data")
    @ApiOperation(value = "上传视频", notes = "上传视频的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "bgmId", value = "背景音乐ID", required = false, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "videoSeconds", value = "视频播放长度", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "videoWidth", value = "视频宽度", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "vidioHeight", value = "视频高度", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "desc", value = "视频描述", required = false, dataType = "String", paramType = "form"),
    })
    public GXJSONResult upload(String userId, String bgmId, double videoSeconds,
                               int videoWidth, int vidioHeight, String desc,
                               @ApiParam(value = "短视频", required = true) MultipartFile file) throws Exception {
        if (StringUtils.isBlank(userId)) {
            return GXJSONResult.errorMsg("用户ID不能为空！");
        }
        //工作流
        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        String fileSpase = "D:/guoxuezhishi";
        String uploadPathDB = "/" + userId + "/video";
        try {
            if (file != null && file.getSize() > 0) {
                String fileName = file.getOriginalFilename();
                if (StringUtils.isNotBlank(fileName)) {
                    String finalVideoPath = fileSpase + uploadPathDB + "/" + fileName;
                    uploadPathDB += ("/" + fileName);

                    File outfile = new File(finalVideoPath);
                    if (outfile.getParentFile() != null || !outfile.getParentFile().isDirectory()) {
                        outfile.getParentFile().mkdirs();
                    }

                    fileOutputStream = new FileOutputStream(outfile);
                    inputStream = file.getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }
            } else {
                return GXJSONResult.errorMsg("上传出错！");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return GXJSONResult.errorMsg("上传出错！");
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }

        //判断bgmId是否为空，如果不为空
        //就查询bgm的信息，并且合并视频，产生新的视频
//        if (StringUtils.isNotBlank(bgmId)) {
//        }






        return GXJSONResult.ok();
    }
}
