package com.guoxuezhishi.test;

import org.junit.Test;

import java.security.SecureRandom;

/**
 * @author: jiang
 * @date: 2019/7/30
 */
public class RandomTest {
    @Test
    public void random() throws InterruptedException {
        String result = "";
        SecureRandom secureRandom = new SecureRandom();
/*        for (int i = 0; i < 99999; i++) {
            System.out.println(secureRandom.nextInt(89999) + 10000);
        }*/
        while (true) {
            int dom = secureRandom.nextInt(10);
            Thread.sleep(1000);
            result = result + String.valueOf(dom);
            System.out.println(result);
        }

    }
}
