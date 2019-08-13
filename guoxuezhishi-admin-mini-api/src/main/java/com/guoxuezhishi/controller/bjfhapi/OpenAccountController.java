package com.guoxuezhishi.controller.bjfhapi;

import com.guoxuezhishi.bean.BjfhApiBeanProp;
import com.guoxuezhishi.pojo.bjfhapi.OpenAccountBO;
import com.guoxuezhishi.pojo.bjfhapi.restapi.BjfhApiRestApiRequest;
import com.guoxuezhishi.pojo.bjfhapi.restapi.BjfhApiRestApiResponse;
import com.guoxuezhishi.utils.GXJSONResult;
import com.icbc.api.IcbcApiException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jiang
 * @date: 2019/7/9
 */
@RestController
@Api(value = "开户-包含短信验证码", tags = {"开户-包含短信验证码"})
public class OpenAccountController {
    @Autowired
    private BjfhApiBeanProp bjfhApiBeanProp;
    @Autowired
    private static Logger logger = Logger.getLogger(SpringBootApplication.class);

    @PostMapping("OpenAccount")
    @ApiOperation(value = "OpenAccount", notes = "OpenAccount")
    public GXJSONResult queryAccount(@RequestBody OpenAccountBO openAccountBO) throws IcbcApiException {
        //生成业务参数对象
        BjfhApiRestApiRequest.BjfhApiRestApiRequestBiz bizContent = new BjfhApiRestApiRequest.BjfhApiRestApiRequestBiz();
        bizContent.setCorpNo(bjfhApiBeanProp.getCorpNo());
        BeanUtils.copyProperties(openAccountBO, bizContent);
        //生成请求类对象
        BjfhApiRestApiRequest request = new BjfhApiRestApiRequest();
        request.setServiceUrl(bjfhApiBeanProp.getServiceUrl() + bjfhApiBeanProp.getAccOpen());
        request.setBizContent(bizContent);
        logger.info("nationality---" + this.getClass().getName()+request.getBizContent());
        BjfhApiRestApiResponse response = BjfhUtil.BjfhResponsse(request, bjfhApiBeanProp);
        return GXJSONResult.ok(response);
    }
}

