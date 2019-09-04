package com.guoxuezhishi.controller.ssh;

import ch.ethz.ssh2.Connection;
import com.guoxuezhishi.bean.SshBeanProp;
import com.guoxuezhishi.utils.GXJSONResult;
import com.guoxuezhishi.utils.RemoteCommandUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jiang
 * @date: 2019/9/4
 */
@RestController
@Api(value = "SSH控制台", tags = "SSH控制台")
public class SendMsgController {
    @Autowired
    private static Logger logger = Logger.getLogger(SpringApplication.class);
    @Autowired
    private SshBeanProp sshBeanProp;

    @PostMapping("SendMsg")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ip", value = "ip", defaultValue = "dev", required = true, dataType = "String"),
            @ApiImplicitParam(name = "cmd", value = "cmd", defaultValue = "cloud_acc=11111&cloud_acc_name=发票推送停车场(修改)&acc=3333&super_acc=4444", required = true, dataType = "String")
    })
    public GXJSONResult SendMsg(String ip, String cmd) {
        Connection login = null;
        logger.info("建立ssh连接");
        if (StringUtils.equals(ip, "dev")) {
            login = RemoteCommandUtil.login(sshBeanProp.getTingcheuatip(), sshBeanProp.getPort(), sshBeanProp.getGsdpay(), sshBeanProp.getGsdpayst());
        } else if (StringUtils.equals(ip, "uat")) {
            login = RemoteCommandUtil.login(sshBeanProp.getTingcheuatip(), sshBeanProp.getPort(), sshBeanProp.getGsdpay(), sshBeanProp.getGsdpayst());
        }
        logger.info("执行命令");
        StringBuffer sb = new StringBuffer();
        sb.append("source .bash_profile && ")
                .append("sendmsg ")
                .append("bpcspub3 ")
                .append("cloudOpenAccount ")
                .append("-d ")
                .append("\"")
                .append(cmd)
                .append("\"");
        String execute = RemoteCommandUtil.execute(login, sb.toString());
        return GXJSONResult.ok(execute);
    }

}
