package com.guoxuezhishi.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringUtilsTest {
    //两侧补全
    @Test
    public void test01() {
        String str = "001";
        String s = StringUtils.leftPad(str, 3, "0");
        System.out.println(s);
    }

}
