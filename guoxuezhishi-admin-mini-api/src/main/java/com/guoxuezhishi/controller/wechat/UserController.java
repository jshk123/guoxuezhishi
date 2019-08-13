package com.guoxuezhishi.controller.wechat;

import com.guoxuezhishi.pojo.wechat.Users;
import com.guoxuezhishi.pojo.vo.UsersVO;
import com.guoxuezhishi.service.UserService;
import com.guoxuezhishi.utils.GXJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@Api(value = "用户相关业务接口", tags = {"用户相关业务接口"})
@RequestMapping("/user")
public class UserController extends BasicController {
    @Autowired
    private UserService userService;

    @PostMapping("/uploadFace")
    @ApiOperation(value = "用户上传头像接口", notes = "用户上传头像接口")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String", paramType = "query")
    public GXJSONResult uploadFace(String userId, @RequestParam("file") MultipartFile[] files) throws Exception {
        if (StringUtils.isBlank(userId)) {
            return GXJSONResult.errorMsg("用户ID不能为空！");
        }
        //文件保存的命名空间
        String fileSpace = "D:/guoxuezhishi";
        //保存到数据库中的相对路径
        String uploadPathDB = "/" + userId + "/face";
        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try {
            if (files != null && files.length > 0) {

                String fileName = files[0].getOriginalFilename();
                if (StringUtils.isNotBlank(fileName)) {
                    //文件上传的最终保存路径
                    String finalFacePath = fileSpace + uploadPathDB + "/" + fileName;
                    //设置数据库保存的路径
                    uploadPathDB += ("/" + fileName);

                    File outFile = new File(finalFacePath);
                    if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                        //创建父文件夹
                        outFile.getParentFile().mkdirs();
                    }
                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = files[0].getInputStream();
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
        Users user = new Users();
        user.setId(userId);
        user.setFaceImage(uploadPathDB);
        userService.updateUserInfo(user);
        return GXJSONResult.ok(uploadPathDB);
    }

    @PostMapping("/query")
    @ApiOperation(value = "用户信息查询", notes = "用户信息查询")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String", paramType = "query")
    public GXJSONResult query(String userId) throws Exception {
        if (StringUtils.isBlank(userId)) {
            return GXJSONResult.errorMsg("用户ID不能为空...");
        }
        Users userInfo = userService.queryUserInfo(userId);
        UsersVO usersVO = new UsersVO();
        BeanUtils.copyProperties(userInfo, usersVO);
        return GXJSONResult.ok(usersVO);
    }

}
