package com.guoxuezhishi.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.security.SecureRandom;

/**
 * @author: jiang
 * @date: 2019/7/30
 */
public class RandomTest {
    //  15741719   60994

    //  15741720   30370
    @Test
    public void random() throws InterruptedException {
        String result = "";
        SecureRandom secureRandom = new SecureRandom();
        Long secureSeed0 = 0L;
        int i = 1;
        while (true) {
            secureRandom.setSeed(15741719);
            int randI = secureRandom.nextInt(10);
            String ret = String.valueOf(randI);
            ret = StringUtils.leftPad(ret, 1, "0");
            System.out.println(i + "--->" + ret);
            if (i == 5) {
                break;
            }
            i++;
            Thread.sleep(100);
        }
  /*      while (true) {
            Long tm = System.currentTimeMillis();
            System.out.println(tm);
            Thread.sleep(1000);
        }*/

   /*     byte[] secureSeed1 = new byte[]{1};
        secureRandom.setSeed(secureSeed1);
        System.out.println("1--->" + secureRandom.nextInt(10));

        byte[] secureSeed2 = new byte[]{2};
        secureRandom.setSeed(secureSeed2);
        System.out.println("2--->" + secureRandom.nextInt(10));

        byte[] secureSeed3 = new byte[]{3};
        secureRandom.setSeed(secureSeed3);
        System.out.println("3--->" + secureRandom.nextInt(10));

        byte[] secureSeed4 = new byte[]{4};
        secureRandom.setSeed(secureSeed4);
        System.out.println("4--->" + secureRandom.nextInt(10));

        byte[] secureSeed5 = new byte[]{5};
        secureRandom.setSeed(secureSeed5);
        System.out.println("5--->" + secureRandom.nextInt(10));

        byte[] secureSeed6 = new byte[]{6};
        secureRandom.setSeed(secureSeed6);
        System.out.println("6--->" + secureRandom.nextInt(10));

        byte[] secureSeed7 = new byte[]{7};
        secureRandom.setSeed(secureSeed7);
        System.out.println("7--->" + secureRandom.nextInt(10));

        byte[] secureSeed8 = new byte[]{8};
        secureRandom.setSeed(secureSeed8);
        System.out.println("8--->" + secureRandom.nextInt(10));

        byte[] secureSeed9 = new byte[]{9};
        secureRandom.setSeed(secureSeed9);
        System.out.println("9--->" + secureRandom.nextInt(10));
*/

        /*        for (int i = 0; i < 99999; i++) {
            System.out.println("0--->"+secureRandom.nextInt(89999) + 10000);
        }*/
/*        while (true) {
            int dom = "0--->"+secureRandom.nextInt(10);
            Thread.sleep(1000);
            result = result + String.valueOf(dom);
            System.out.println(result);
        }*/

    }
}
