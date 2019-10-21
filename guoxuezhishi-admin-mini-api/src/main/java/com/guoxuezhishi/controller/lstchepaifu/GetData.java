package com.guoxuezhishi.controller.lstchepaifu;

import com.guoxuezhishi.aes.MrAesUtils;
import com.guoxuezhishi.aes.MrAesUtilsCbcMod;
import com.guoxuezhishi.aes.MrBase64;
import com.guoxuezhishi.aes.MrDes;
import com.guoxuezhishi.aes.MrEncFillUtils;
import com.guoxuezhishi.aes.MrTdes;
import com.guoxuezhishi.aes.MrTdesCbcMod;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: jiang
 * @date: 2019/8/15
 * 获取数据
 */
public class GetData {

    public String getVdata(String t, String d, String v) throws Exception {
        String flag = t.substring(t.length() - 1, t.length());
        int hash = flag.hashCode();
        String recData = null;
        switch (hash) {
            case 49:
                recData = aesDecrypt(t, d, v);
                break;
            case 50:
                recData = desDecrypt(t, d, v);
                break;
            case 51:
                recData = tDesDecrypt(t, d, v);
                break;
            default:
                break;
        }
        System.out.println("recData: "+recData);
        return recData;
    }

    private String aesEncrypt(String t, String d, String v) throws Exception {
        String encKey = MrEncFillUtils.fillEncData(t, 32);
        byte[] datas;
        String enStr;
        if (StringUtils.isBlank(v)) {
            datas = MrAesUtils.encrypt(d.getBytes(), encKey.getBytes());
            enStr = MrBase64.encode(datas);
        } else {
            datas = MrAesUtilsCbcMod.encrypt(d.getBytes(), encKey.getBytes());
            enStr = MrBase64.encode(datas);
        }
        return enStr;
    }

    private String aesDecrypt(String t, String d, String v) throws Exception {
        String encKey = MrEncFillUtils.fillEncData(t, 32);
        byte[] datas;
        if (StringUtils.isBlank(v)) {
            datas = MrAesUtils.decrypt(MrBase64.decode(d), encKey.getBytes());
        } else {
            datas = MrAesUtilsCbcMod.decrypt(MrBase64.decode(d), encKey.getBytes());
        }
        return new String(datas,"GBK");
    }

    private String desEncrypt(String t, String d, String v) throws Exception {
        String encKey = MrEncFillUtils.fillEncData(t, 32);
        String datas = "";
        datas = MrDes.encrypt(d, encKey);
        return datas;
    }

    private String desDecrypt(String t, String d, String v) throws Exception {
        String encData = d.replace("\n", "").replace("\\", "");
        String encKey = MrEncFillUtils.fillEncData(t, 32);
        String datas = "";
        datas = MrDes.decrypt(encData, encKey);
        return datas;
    }

    private String tDesEncrypt(String t, String d, String v) throws Exception {
        String encKey = MrEncFillUtils.fillEncData(t, 32);
        String datas = "";
        if (StringUtils.isBlank(v)) {
            datas = MrTdes.encryptThreeDESECB(d, encKey);
        } else {
            datas = MrTdesCbcMod.encryptThreeDESECB(d, encKey);
        }
        return datas;
    }

    private String tDesDecrypt(String t, String d, String v) throws Exception {
        String encData = d.replace("\n", "").replace("\\", "");
        String encKey = MrEncFillUtils.fillEncData(t, 32);
        String datas = "";
        if (StringUtils.isBlank(v)) {
            datas = MrTdes.decryptThreeDESECB(encData, encKey);
        } else {
            datas = MrTdesCbcMod.decryptThreeDESECB(encData, encKey);
        }
        return datas;
    }

    public static void main(String[] args) throws Exception {
        GetData getData = new GetData();
        String t = "1396097488322";
        String d = "lFf1AHAJysShEYqASlVbssejWVet2hK5f7GoVY27+RIGNq3BrUkKHKkWcKqQL7uOa4fVKj4Kp0Jb 1U+HDd2uQVs3MeDHJnqzC5MfOCc7Rwg0rrkTMz1MhPPszUoLambaV21V+nPT2ZE1AD/4KDD7KQEF WOxnBW/T/tzAOatHRtI=";
        String v = "";
        String vdata = getData.getVdata(t, d, v);
        System.out.println("vdata: " + vdata);
    }

}
