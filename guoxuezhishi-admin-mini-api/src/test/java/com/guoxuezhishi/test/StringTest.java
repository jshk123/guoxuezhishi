package com.guoxuezhishi.test;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: jiang
 * @date: 2019/10/24
 */
public class StringTest {
    /**
     * 对字符串进行排序
     */
    @Test
    public void test1() {
        String a = "cfdasbv";
        char[] b = a.toCharArray();
        Arrays.sort(b);
        a = new String(b);
        System.out.println(a);
    }

}
