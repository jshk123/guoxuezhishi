package com.guoxuezhishi.controller.jiaohangyun;

import com.guoxuezhishi.pojo.jiaohangyun.CloudTransferAccountDO;
import com.guoxuezhishi.utils.GXJSONResult;
import com.guoxuezhishi.utils.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jiang
 * @date: 2019/8/5
 */
@RestController
@Api(value = "交通银行云账户划拨处理", tags = "交通银行云账户划拨处理")
public class CloudTransferAccountController {
    @PostMapping("/CloudTransferAccount")
    @ApiOperation(value = "CloudTransferAccount", notes = " CloudTransferAccount")
    public GXJSONResult remoteCommand(@RequestBody CloudTransferAccountDO cloudTransferAccountDO) {
        StringBuffer reqUrl = new StringBuffer();
        reqUrl.append("http://172.20.53.130:8280/sysmng/bpcspub3/cloudTransferAccount.do")
                .append("?acc=").append(cloudTransferAccountDO.getAcc())
                .append("?ord_no=").append(cloudTransferAccountDO.getOrdNo())
                .append("?pay_acno=").append(cloudTransferAccountDO.getPayAcno())
                .append("?pay_acname=").append(cloudTransferAccountDO.getPayAcname())
                .append("?rcv_acno=").append(cloudTransferAccountDO.getRcvAcno())
                .append("?rcv_acname=").append(cloudTransferAccountDO.getRcvAcname())
                .append("?amt=").append(cloudTransferAccountDO.getAmt())
                .append("?bank_flag=").append(cloudTransferAccountDO.getBankFlag())
                .append("?rcv_bank_name=").append(cloudTransferAccountDO.getRcvBankName())
                .append("?rcv_bank_no=").append(cloudTransferAccountDO.getRcvBankNo());
        String response = HttpUtils.sendPost(reqUrl.toString(), "", "UTF-8");
        JSONObject rsponse = JSONObject.fromObject(response);
        return GXJSONResult.ok(rsponse);
    }
}
