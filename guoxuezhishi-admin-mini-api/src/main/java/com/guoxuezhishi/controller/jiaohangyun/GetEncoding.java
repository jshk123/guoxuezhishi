package com.guoxuezhishi.controller.jiaohangyun;

import java.io.UnsupportedEncodingException;

/**
 * @author: jiang
 * @date: 2019/8/16
 */
public class GetEncoding {

    public static String getEncoding(String str) throws UnsupportedEncodingException {
        String encode;
        encode = "GB2312";
        if (str.equals(new String(str.getBytes(), encode))) {
            return encode;
        }

        encode = "ISO-8859-1";
        if (str.equals(new String(str.getBytes(), encode))) {
            return encode;
        }

        encode = "GBK";
        if (str.equals(new String(str.getBytes(), encode))) {
            return encode;
        }

        encode = "UTF-8";
        if (str.equals(new String(str.getBytes(), encode))) {
            return encode;
        }

        return "未识别编码格式";
    }

}
