package com.guoxuezhishi.psam;

import com.alibaba.fastjson.JSONObject;

import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author: jiang
 * @date: 2019/11/27
 */
public class MD5paixu {
    public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static String createSign(TreeMap<String, Object> parameters, String key) {
        StringBuffer sb = new StringBuffer();
        StringBuffer sbkey = new StringBuffer();
        Set es = parameters.entrySet();  //所有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            //空值不传递，不参与签名组串
            if (null != v && !"".equals(v)) {
                sb.append(k + "=" + v + "&");
                sbkey.append(k + "=" + v + "&");
            }
        }
        sbkey = sbkey.append("key=" + key);
        return sbkey.toString();
    }

    public static void main(String[] args) {
        TreeMap<String, Object> org = new TreeMap<String, Object>();
        org.put("proListNo", "110109201907192108098163598438338315");
        org.put("stationName", "xx 收费站");
        org.put("roadCode", "1");
        org.put("psamNo", "11010000000000000001");
        org.put("keyVersion", "51");
        org.put("provinceCode", "1101");
        org.put("roadName", "某某高速");
        org.put("stationCode", "2");
        org.put("random", "E87A21B9000000000000000000000000");
        org.put("laneNo", "35");
        org.put("laneType", "02");
        org.put("stationType", "02");
        String org1 = createSign(org, "asdafE23EDioj124");
        System.out.println(org1);
        String org2 = MD5("org");
        System.out.println(org2);
        org.put("key", org2);
        JSONObject jsonObject = new JSONObject(org);
        System.out.println(jsonObject);

    }
}
