package com.guoxuezhishi.controller.bjfhapi;

import com.guoxuezhishi.bean.BjfhApiBeanProp;
import com.guoxuezhishi.pojo.bjfhapi.QueryAccountBO;
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

import static com.guoxuezhishi.controller.bjfhapi.BjfhUtil.BjfhResponsse;

/**
 * @author: jiang
 * @date: 2019/7/5
 */
@RestController
@Api(value = "查询用户开户信息", tags = {"查询用户开户信息"})
public class QueryAccountController {
    @Autowired
    private BjfhApiBeanProp bjfhApiBeanProp;
    @Autowired
    private static Logger logger = Logger.getLogger(SpringBootApplication.class);

    @PostMapping("QueryAccount")
    @ApiOperation(value = "QueryAccount", notes = " QueryAccount")
    public GXJSONResult queryAccount(@RequestBody QueryAccountBO queryAccountBO) throws IcbcApiException {
        //生成业务参数对象
        BjfhApiRestApiRequest.BjfhApiRestApiRequestBiz bizContent = new BjfhApiRestApiRequest.BjfhApiRestApiRequestBiz();
        bizContent.setCorpNo(bjfhApiBeanProp.getCorpNo());
        BeanUtils.copyProperties(queryAccountBO, bizContent);
        //生成请求类对象
        BjfhApiRestApiRequest request = new BjfhApiRestApiRequest();
        request.setServiceUrl(bjfhApiBeanProp.getServiceUrl() + bjfhApiBeanProp.getQryAcc());
        request.setBizContent(bizContent);
        logger.info("bjfhApiBeanProp.getAppId---" + bjfhApiBeanProp.getAppId());
        BjfhApiRestApiResponse response = BjfhResponsse(request, bjfhApiBeanProp);
        return GXJSONResult.ok(response);
    }

}
