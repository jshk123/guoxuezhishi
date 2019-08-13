package com.guoxuezhishi.utils;

import org.apache.commons.lang3.StringUtils;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author: jiang
 * @date: 2019/7/3
 */
public class Pubutil {
    /**
     * 生成32位随机字符串
     *
     * @return
     */
    public static String create_nonce_str() {
        String s = UUID.randomUUID().toString();
        // 去掉“-”符号并大写
        return s.replaceAll("\\-", "").toUpperCase();
    }

    /**
     * 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序），并且生成url参数串<
     *
     * @param paraMap    要排序的Map对象
     * @param urlEncode  是否需要URLENCODE
     * @param keyToLower 是否需要将Key转换为全小写 true:key 转化成小写，false:不转化
     * @return
     */
    public static String formatUrlMap(Map<String, String> paraMap, boolean urlEncode, boolean keyToLower) {
        String buff = "";
        try {
            List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(paraMap.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
                @Override
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });
            // 构造URL 键值对的格式
            StringBuilder buf = new StringBuilder();
            for (Map.Entry<String, String> item : infoIds) {
                if (StringUtils.isNotBlank(item.getKey())) {
                    String key = item.getKey();
                    String val = item.getValue();
                    if (urlEncode) {
                        val = URLEncoder.encode(val, "utf-8");
                    }
                    if (keyToLower) {
                        buf.append(key.toLowerCase() + "=" + val);
                    } else {
                        buf.append(key + "=" + val);
                    }
                    buf.append("&");
                }

            }
            buff = buf.toString();
            if (buff.isEmpty() == false) {
                buff = buff.substring(0, buff.length() - 1);
            }
        } catch (Exception e) {
            return null;
        }
        return buff;
    }

    /**
     * 将键值对转换成xml格式字符串
     */
    public static String mapToXml(Map<String, String> map, boolean isAddCDATA) {
        StringBuffer strbuff = new StringBuffer("<xml>");
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                strbuff.append("<").append(entry.getKey()).append(">");
                if (isAddCDATA) {
                    strbuff.append("<![CDATA[");
                    if (StringUtils.isNotEmpty(entry.getValue())) {
                        strbuff.append(entry.getValue());
                    }
                    strbuff.append("]]>");
                } else {
                    if (StringUtils.isNotEmpty(entry.getValue())) {
                        strbuff.append(entry.getValue());
                    }
                }
                strbuff.append("</").append(entry.getKey()).append(">");
            }
        }
        return strbuff.append("</xml>").toString();
    }

    public static void main(String[] args) throws Exception {
        String nonceStrResult = create_nonce_str();
        System.out.println(nonceStrResult + "  :  长度- " + nonceStrResult.length());
        Map<String, String> map = new HashMap();
        map.put("appid", "wxd930ea5d5a258f4f");
        map.put("mch_id", "10000100");
        map.put("device_info", "1000");
        map.put("body", "test");
        map.put("nonce_str", "ibuaiVcKdpRxkhJA");
        String signTemp = formatUrlMap(map, false, false);
        System.out.println(signTemp);
        signTemp = signTemp + "&key=192006250b4c09247ec02edce69f6a2d";
        String signMD5 = MD5Utils.md5PasswordWX(signTemp).toUpperCase();
        System.out.println(signMD5);
        map.put("sign", signMD5);
        String xmlFormat = mapToXml(map, false);
        System.out.println(xmlFormat);
    }
}
