package com.guoxuezhishi.controller.wechat;

import com.guoxuezhishi.pojo.wechat.Users;
import com.guoxuezhishi.pojo.vo.UsersVO;
import com.guoxuezhishi.service.UserService;
import com.guoxuezhishi.utils.GXJSONResult;
import com.guoxuezhishi.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Api(value = "用户注册登陆接口", tags = {"用户注册登陆接口"})
public class RegistLoginController extends BasicController {
    @Autowired
    private UserService userService;

    public UsersVO setUserRedisSessionToken(Users users) {
        String uniqueToken = UUID.randomUUID().toString();
        redis.set(USER_REDIS_SESSION + ":" + users.getId(), uniqueToken, 1000 * 60 * 30);
        UsersVO usersVO = new UsersVO();
        BeanUtils.copyProperties(users, usersVO);
        usersVO.setUserToken(uniqueToken);
        return usersVO;
    }

    @PostMapping("/regist")
    @ApiOperation(value = "用户注册接口", notes = "用户注册接口")
    public GXJSONResult regist(@RequestBody Users user) throws Exception {

        // 1. 判断用户名和密码必须不为空
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return GXJSONResult.errorMsg("用户名和密码不能为空");
        }
        // 2. 判断用户名是否存在
        boolean userNameIsExist = userService.queryUserNameIsExist(user.getUsername());
        // 3. 保存用户，注册信息
        if (!userNameIsExist) {
            user.setNickname(user.getUsername());
            user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
            user.setFansCounts(0);
            user.setReceiveLikeCounts(0);
            user.setFollowCounts(0);
            userService.saveUser(user);
        } else {
            return GXJSONResult.errorMsg("用户名已经存在，请换一个再试");
        }
        user.setPassword("");
        UsersVO usersVO = setUserRedisSessionToken(user);
        return GXJSONResult.ok(usersVO);
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登陆接口", notes = "用户登陆接口")
    public GXJSONResult login(@RequestBody Users user) throws Exception {

        // 1. 判断用户名和密码必须不为空
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return GXJSONResult.errorMsg("用户名和密码不能为空");
        }
        // 2. 判断用户是否存在
        Users userResult = userService.queryUserForLogin(user.getUsername(), MD5Utils.getMD5Str(user.getPassword()));
        // 3. 保存用户，注册信息
        if (userResult != null) {
            userResult.setPassword("");
            UsersVO usersVO = setUserRedisSessionToken(userResult);
            return GXJSONResult.ok(usersVO);
        } else {
            return GXJSONResult.errorMsg("用户名或密码不正确，请重试!");
        }
    }

    @PostMapping("/logout")
    @ApiOperation(value = "用户注销接口", notes = "用户注销接口")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String", paramType = "query")
    public GXJSONResult logout(String userId) throws Exception {
        redis.del(USER_REDIS_SESSION + ":" + userId);
        return GXJSONResult.ok("用户缓存删除成功！");
    }

}
