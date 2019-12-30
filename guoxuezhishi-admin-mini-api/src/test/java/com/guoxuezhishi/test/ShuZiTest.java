package com.guoxuezhishi.test;

import org.junit.Test;

import java.math.BigDecimal;

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

    /**
     * bigdecimal计算
     */
    @Test
    public void shuzi5() {
        BigDecimal t1 = new BigDecimal(1.233);
        BigDecimal t2 = new BigDecimal(1.273);
        BigDecimal t3 = new BigDecimal(1.233);
        int i1 = t1.compareTo(t2);
        int i2 = t1.compareTo(t3);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(t1.equals(t2));

//        System.out.println(t1.add(t2));
//        System.out.println(t1.add(t2).setScale(2, BigDecimal.ROUND_HALF_UP));
//        System.out.println(t3);
    }

}
