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
}
