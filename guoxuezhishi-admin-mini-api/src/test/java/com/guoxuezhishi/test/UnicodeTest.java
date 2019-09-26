package com.guoxuezhishi.test;

import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: jiang
 * @date: 2019/9/12
 */
public class UnicodeTest {
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

    public static void main(String[] args) {
        String test = "unicode转字符串";
        String utest = stringToUnicode(test);
        System.out.println(utest);
        Map<String, Object> resmap = new LinkedHashMap();
        resmap.put("response", utest);
        JSONObject jsonObject = JSONObject.fromObject(resmap);
        System.out.println(StringEscapeUtils.unescapeJava(String.valueOf(jsonObject)));
        System.out.println(StringEscapeUtils.escapeJava(test));
    }
}
