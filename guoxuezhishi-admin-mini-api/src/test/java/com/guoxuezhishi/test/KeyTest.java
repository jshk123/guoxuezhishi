package com.guoxuezhishi.test;

import com.guoxuezhishi.aes.MrAesUtils;
import com.guoxuezhishi.aes.MrAesUtilsCbcMod;
import com.guoxuezhishi.aes.MrBase64;
import com.guoxuezhishi.aes.MrDes;
import com.guoxuezhishi.aes.MrEncFillUtils;
import com.guoxuezhishi.aes.MrTdes;
import com.guoxuezhishi.aes.MrTdesCbcMod;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;

/**
 * @author: jiang
 * @date: 2019/8/15
 */
public class KeyTest {
    private static String json = "<root><returnCode>MCA00000</returnCode><returnMsg>交易成功</returnMsg><serviceTime>20190815100412</serviceTime><v>1.1</v><mblNo/></root>";
    private static String version = "1.1";

    public static void main(String[] args) throws Exception {
        //加解密测试
        key1();

    }

    public static void key1() throws Exception {
        KeyTest keyTest = new KeyTest();
        Random random = new Random();
        int rec = random.nextInt(31);
        System.out.println("random:" + rec);
        String preKey = MrEncFillUtils.generateString(rec);
        System.out.println("preKey:" + preKey);
        String flag = preKey.substring(preKey.length() - 1, preKey.length());
        int hash = flag.hashCode();
        System.out.println("flag:" + flag + "    hash:" + hash);
        String recData = null;
        switch (hash) {
            case 49:
                recData = keyTest.aesEncrypt(preKey);
                keyTest.aesDecrypt(preKey, recData);
                break;
            case 50:
                recData = keyTest.desEncrypt(preKey);
                keyTest.desDecrypt(preKey, recData);
                break;
            case 51:
                recData = keyTest.tDesEncrypt(preKey);
                keyTest.tDesDecrypt(preKey, recData);
                break;
            default:
                break;
        }

    }

    private String aesEncrypt(String preKey) throws Exception {
        String encKey = MrEncFillUtils.fillEncData(preKey, 32);
        System.out.println("加密encKey:" + encKey);
        byte[] datas;
        String enStr;
        if (StringUtils.isBlank(version)) {
            datas = MrAesUtils.encrypt(json.getBytes(), encKey.getBytes());
            enStr = MrBase64.encode(datas);
        } else {
            datas = MrAesUtilsCbcMod.encrypt(json.getBytes(), encKey.getBytes());
            enStr = MrBase64.encode(datas);
        }
        System.out.println("加密后串：" + enStr);
        return enStr;
    }

    private void aesDecrypt(String preKey, String recData) throws Exception {
        System.out.println("接收原始数据：" + recData);
        String encKey = MrEncFillUtils.fillEncData(preKey, 32);
        byte[] datas;
        if (StringUtils.isBlank(version)) {
            datas = MrAesUtils.decrypt(MrBase64.decode(recData), encKey.getBytes());
        } else {
            datas = MrAesUtilsCbcMod.decrypt(MrBase64.decode(recData), encKey.getBytes());
        }
        System.out.println("解密后数据：" + new String(datas));
    }

    private String desEncrypt(String preKey) throws Exception {
        String encKey = MrEncFillUtils.fillEncData(preKey, 32);
        System.out.println("加密encKey:" + encKey);
        String datas = "";
        datas = MrDes.encrypt(json, encKey);
        System.out.println("加密后串：" + datas);
        return datas;
    }

    private void desDecrypt(String preKey, String recData) throws Exception {
        System.out.println("接收原始数据：" + recData);
        String encData = recData.replace("\n", "").replace("\\", "");
        String encKey = MrEncFillUtils.fillEncData(preKey, 32);
        String datas = "";
        datas = MrDes.decrypt(encData, encKey);
        System.out.println("解密后数据：" + datas);
    }

    private String tDesEncrypt(String preKey) throws Exception {
        String encKey = MrEncFillUtils.fillEncData(preKey, 32);
        System.out.println("加密encKey:" + encKey);
        String datas = "";
        if (StringUtils.isBlank(version)) {
            datas = MrTdes.encryptThreeDESECB(json, encKey);
        } else {
            datas = MrTdesCbcMod.encryptThreeDESECB(json, encKey);
        }
        System.out.println("加密后串：" + datas);
        return datas;
    }

    private void tDesDecrypt(String preKey, String recData) throws Exception {
        String encData = recData.replace("\n", "").replace("\\", "");
        String encKey = MrEncFillUtils.fillEncData(preKey, 32);
        String datas = "";
        if (StringUtils.isBlank(version)) {
            datas = MrTdes.decryptThreeDESECB(encData, encKey);
        } else {
            datas = MrTdesCbcMod.decryptThreeDESECB(encData, encKey);
        }
        System.out.println("解密后数据：" + datas);
    }

}
