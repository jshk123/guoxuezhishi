package com.guoxuezhishi.aes;

import java.util.Random;

/**
 * @author: jiang
 * @date: 2019/8/15
 */
public class MrEncFillUtils {
    public static final String DATA_D = "d";
    public static final String DATA_T = "t";
    public static final String DATA_V = "v";

    public MrEncFillUtils() {
    }

    public static String fillEncData(String srcKey, int length) {
        String finalKey = "";
        int fillLen = length - srcKey.length() - 1;
        finalKey = srcKey + "|";

        for (int i = 0; i < fillLen; ++i) {
            finalKey = finalKey + "F";
        }

        return finalKey;
    }

    public static String generateString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();

        for (int i = 0; i < length - 1; ++i) {
            sb.append("1234567890".charAt(random.nextInt("1234567890".length())));
        }

        sb.append("123".charAt(random.nextInt("123".length())));
        return sb.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        String preKey = generateString(random.nextInt(31));
        System.out.println(preKey);
        System.out.println(preKey.substring(preKey.length() - 1, preKey.length()));
        System.out.println(fillEncData(preKey, 32));
    }
}
