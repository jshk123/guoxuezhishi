package com.guoxuezhishi.test;

/**
 * @author: jiang
 * @date: 2019/8/13
 */
public class StringTest {
    public static void main(String[] args) {
        String rec = "发票推送停车场(修改)";
        StringBuffer sb = new StringBuffer("你啊哈，");
        sb.append(rec);
        System.out.println(sb);

    }
}
