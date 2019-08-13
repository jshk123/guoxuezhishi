package com.guoxuezhishi.utils;

import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: jiang
 * @date: 2019/7/4
 */
public class MerchantUtil {
    public MerchantUtil() {
    }

    public static void getChkFile(String url, String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String res = sendAndRecv(url, "", "GBK");
            if (!StringUtils.isBlank(res)) {
                bw.write(res);
            }

            bw.close();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public static String sendAndRecv(String url, String buf, String characterSet) throws IOException {
        String charType;
        if ("00".equals(characterSet)) {
            charType = "GBK";
        } else if ("01".equals(characterSet)) {
            charType = "GB2312";
        } else if ("02".equals(characterSet)) {
            charType = "UTF-8";
        } else {
            charType = "GBK";
        }

        Map reqMap = new HashMap();
        HttpSendResult res = null;
        SimpleHttpsClient httpsClient = new SimpleHttpsClient();

        try {
            (new JsonParser()).parse(buf);
            res = httpsClient.jsonPostRequest(url, buf, 120000, charType);
        } catch (JsonParseException var14) {
            System.out.println("is not json");
            String[] resArr = StringUtils.split(buf, "&");

            for (int i = 0; i < resArr.length; ++i) {
                String data = resArr[i];
                int index = StringUtils.indexOf(data, '=');
                String nm = StringUtils.substring(data, 0, index);
                String val = StringUtils.substring(data, index + 1);
                reqMap.put(nm, val);
            }

            res = httpsClient.postRequest(url, reqMap, 120000, charType);
        }

        String repMsg = res.getResponseBody();
        return repMsg;
    }

    private static HashMap<String, String> toHashMap(Object object) {
        HashMap<String, String> data = new HashMap();
        JSONObject jsonObject = JSONObject.fromObject(object);
        Iterator it = jsonObject.keys();

        while (it.hasNext()) {
            String key = String.valueOf(it.next());
            String value = (String) jsonObject.get(key);
            data.put(key, value);
        }

        return data;
    }

    public static void main(String[] args) {
        getChkFile("http://10.211.1.134:38080/mweb/service/merrecon.xhtml?MERC=800010000010003800010000010003_20141111092325_pay.txt6f4c97a44456143f5bfd31fe77e05227", "D:/chkfile.txt");
    }
}
