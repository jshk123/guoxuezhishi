package com.guoxuezhishi.test;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @author: jiang
 * @date: 2019/7/30
 */
public class TestJson {
    @Test
    public void json1() {
        String json = "{\n" +
                "  \"status\": 200,\n" +
                "  \"msg\": \"OK\",\n" +
                "  \"data\": {\n" +
                "    \"result\": [\n" +
                "      \"你好，百度个大傻逼。\"\n" +
                "    ],\n" +
                "    \"err_msg\": \"success.\",\n" +
                "    \"sn\": \"619932647281564450435\",\n" +
                "    \"corpus_no\": \"6719263455781308090\",\n" +
                "    \"err_no\": 0\n" +
                "  },\n" +
                "  \"ok\": null\n" +
                "}";
        System.out.println(json);
        JSONObject json2 = JSONObject.parseObject(json);
        System.out.println(json2);

    }
}
