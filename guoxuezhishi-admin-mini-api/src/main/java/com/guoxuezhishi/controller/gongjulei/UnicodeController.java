package com.guoxuezhishi.controller.gongjulei;

import com.guoxuezhishi.controller.BaseController;
import com.guoxuezhishi.utils.GXJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: jiang
 * @date: 2019/9/12
 */
@RestController
@Api(value = "Unicode转换", tags = "Unicode转换")
public class UnicodeController extends BaseController {

    @PostMapping("/Unicode")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "type", required = true, dataType = "String", allowableValues = "unicode转中文,中文转unicode"),
            @ApiImplicitParam(name = "content", value = "content", defaultValue = "\\u75\\u6e\\u69\\u63\\u6f\\u64\\u65\\u8f6c\\u5b57\\u7b26\\u4e32",
                    required = true, dataType = "String")
    })
    public GXJSONResult unicode(String type, String content) {
        logger.info("type:" + type);
        logger.info("content:" + content);
        String restult = "";
        if (StringUtils.equals(type, "unicode转中文")) {
            logger.info("unicode转中文");
            restult = unicodeToString(content);
        } else {
            logger.info("中文转unicode");
            restult = stringToUnicode(content);
        }
        Map map = new LinkedHashMap();
        map.put("response", restult);
        JSONObject resJson = JSONObject.fromObject(map);
        return GXJSONResult.ok(resJson);
    }

    /**
     * 字符串转unicode
     */
    public static String stringToUnicode(String str) {
        StringBuffer sb = new StringBuffer();
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            sb.append("\\u" + Integer.toHexString(c[i]));
        }
        return sb.toString();
    }

    /**
     * unicode转字符串
     */
    public static String unicodeToString(String unicode) {
        StringBuffer sb = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            int index = Integer.parseInt(hex[i], 16);
            sb.append((char) index);
        }
        return sb.toString();
    }
}
