package com.guoxuezhishi.test;

import org.junit.Test;

/**
 * @author: jiang
 * @date: 2019/7/31
 */
public class ShuZiTest {
    @Test
    public void shuZi() {
        int n = 4;
        StringBuilder binary = new StringBuilder();
        while (n != 0) {
            binary.insert(0, n % 2);
            System.out.println("binary=" + binary.toString());
            n /= 2;
            System.out.println(n);
        }
        System.out.println("binary=" + binary.toString());
    }

    @Test
    public void shuZi2() {
        int n = 4;
        System.out.println("binary2=" + Integer.toBinaryString(n));
    }

    @Test
    public void shuzi3() {
        int a = -100;
        int b = 100;
        System.out.println(a + b);
    }

    /**
     * 位运算
     */
    @Test
    public void shuzi4() {
        System.out.println("二进制：" + Integer.toBinaryString(16));
        System.out.println("16>>2运算的结果是 :" + ((16) >> 2));
        //打印的结果是:   16>>2运算的结果是 :4
        System.out.println("-16>>2运算的结果是 :" + ((-16) >> 2));
        //打印的结果是:   -16>>2运算的结果是 :-4
        System.out.println("16>>>2运算的结果是 :" + ((16) >>> 2));
        //打印的结果是:   16>>>2运算的结果是 :4
        System.out.println("-16>>>2运算的结果是 :" + ((-16) >>> 2));
        //打印的结果是:   -16>>>2运算的结果是 :1073741820
        System.out.println("16<<2运算的结果是 :" + ((16) << 2));
        System.out.println("-16<<2运算的结果是 :" + ((-16) << 2));
    }

}
