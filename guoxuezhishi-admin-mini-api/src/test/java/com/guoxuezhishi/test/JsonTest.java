package com.guoxuezhishi.test;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @author: jiang
 * @date: 2019/7/30
 */
public class JsonTest {
    @Test
    public void json1() {
        String json = "";
        System.out.println(json);
        JSONObject json2 = JSONObject.parseObject(json);
        System.out.println(json2);

    }
}
