package com.guoxuezhishi.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author: jiang
 * @date: 2020/2/4
 */
public class SscTest {
    int sscos = 0;
    int abc = 0;
    String sscr;
    String baohan[] = {"0", "3", "6", "9"};
    final String furl = "https://www4.hl888champion.com";
    String maUrl = furl + "/cp/loadSiteInfo.do";
    String reqUrl = furl + "/cp/loadDrawSimpleResults.do";
    String danUrl = furl + "/cp/confirmOrder.do";
    String origin = furl;
    String referer = furl + "/cp/hl8/index.jsp?g=HELSSC1&token=d6e8b18c-65ff-40a6-8390-5657737e42c2&acctName=jshk123";
    String cookie = "JSESSIONID=6495701E14CDDEFC3C8B471771DB93E4; __cfduid=d68ded96cc1f0d6ba969b90afb1e594621566831140; homeDox=1; pwdUsername=%7B%22pwdUsername%22%3Anull%7D; JSESSIONID=87295E7EAC1BBF03FEB4349299CA00F7; d=false; t1d=%22https%3A%2F%2Fwww.nicehl888.com%22; Hm_lvt_8334f12485d864d912062492a4e285f6=1581409763; uuid=473f912eaf1b-c759-4a63-b1dd-d882740ba65f; sx_username=jshk123; sx_token=d6e8b18c-65ff-40a6-8390-5657737e42c2; username=%7B%22username%22%3A%22jshk123%22%7D; phone=null; ac=null; dl=null; v=null; depNotifFlag=%7B%22depNotifFlag%22%3A0%7D; transNotifFlag=%7B%22transNotifFlag%22%3A0%7D; i=%7B%22i%22%3A%22473f912eaf1b-c759-4a63-b1dd-d882740ba65f%22%7D; loginSt=1; theme=%7B%22theme%22%3A%22black%22%7D; u=1; count=%221%22; memIpFlag=%7B%22memIpFlag%22%3A1%7D; t=%7B%22aid%22%3A%22Bearer%20eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjdXN0b21DbGFpbSI6IntcIm1lbUlkXCI6MTI3NjM3LFwidXNlcm5hbWVcIjpcImpzaGsxMjNcIixcInRva2VuXCI6XCJkNmU4YjE4Yy02NWZmLTQwYTYtODM5MC01NjU3NzM3ZTQyYzJcIixcImlwXCI6XCIxOTIuMTY4LjIuMTAxXCIsXCJkb21haW5cIjpcInd3dzQuaGw4ODhjaGFtcGlvbi5jb21cIixcImJyb3dzZXJcIjpcIkNocm9tZS9PdGhlcnNcIixcImJyYW5kXCI6XCJITDhcIixcImRldmljZVwiOlwiUFwiLFwibWFya2V0XCI6XCJDTlwiLFwicGxhdGZvcm1cIjpcIklcIn0iLCJpc3MiOiJhdXRoMCIsImFwcENvZGUiOiJoYS1wb3J0YWwtbWVtYmVyIiwidHlwZSI6MiwiZXhwIjoxNTgxNDIwNTgxfQ.gKC_WY6SpS_gLsGlXXZqifMuDfnRjCgbE2wwY1sFSyQ%22%2C%22id%22%3A127637%2C%22u%22%3A%22jshk123%22%2C%22n%22%3A%22%E5%91%BD%E4%B8%AD%E7%99%BE%E5%88%86%E7%99%BE%22%2C%22i%22%3A%22192.168.2.101%22%2C%22t%22%3A%22d6e8b18c-65ff-40a6-8390-5657737e42c2%22%2C%22b%22%3A%220.8350%22%2C%22l%22%3A%7B%22ipAddress%22%3A%22111.193.8.23%22%2C%22location%22%3A%22%E5%8C%97%E4%BA%AC%22%2C%22loginAt%22%3A%222020-02-11T12%3A54%3A19%22%7D%2C%22ph%22%3A%2215668022153%22%2C%22m%22%3A0%7D; ms=%7B%22127637%22%3A%7B%22899483%22%3A%22Y%22%2C%22907641%22%3A%22Y%22%2C%22909644%22%3A%22Y%22%2C%22909696%22%3A%22Y%22%7D%7D; sxc_uuid=473f912eaf1b-c759-4a63-b1dd-d882740ba65f; sxt_uuid=473f912eaf1b-c759-4a63-b1dd-d882740ba65f; token=%22d6e8b18c-65ff-40a6-8390-5657737e42c2%22; Hm_lpvt_8334f12485d864d912062492a4e285f6=1581409798; uuid=473f912eaf1b-c759-4a63-b1dd-d882740ba65f";

    @Test
    public void ssc1() {
        while (true) {
            String response = getPost();
            System.out.println("response" + response);
            JSONObject message = JSONObject.fromObject(response);
            if (!message.get("code").toString().equals("1")) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    continue;
                }
                continue;
            }
            JSONArray message1 = JSONArray.fromObject(message.get("message"));
            boolean flg = false;
            flg = panduan(message1);
            try {
                if (flg) {
                    if (bianma()) {
                        System.out.println("获取下单编码成功");
                        if (xiadan()) {
                            System.out.println("下单成功");
                        } else {
                            System.out.println("下单失败");
                            sscos = 0;
                        }
                    } else {
                        System.out.println("获取下单编码失败");
                        sscos = 0;
                    }
                } else {
                    System.out.println("等待");
                }
                System.out.println("=============================");
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getPost() {
        while (true) {
            try {
                PostMethod postMethod = null;
                postMethod = new PostMethod(reqUrl);
                postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                NameValuePair[] data = {
                        new NameValuePair("siteCode", "HELSSC1"),
                };
                postMethod.setRequestBody(data);
                org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();
                httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(3000);
                httpClient.getHttpConnectionManager().getParams().setSoTimeout(3000);
                int response = 0;// 执行POST方法
                InputStream inputStream = null;
                StringBuffer result = new StringBuffer();
                response = httpClient.executeMethod(postMethod);
                System.out.println("response:" + response);
                if (response == 200) {
                    inputStream = postMethod.getResponseBodyAsStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                    String str = "";
                    while ((str = br.readLine()) != null) {
                        result.append(str);
                    }
                    return result.toString();
                } else {
                    System.out.println("获取期数连接失败！");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean panduan(JSONArray message1) {
        StringBuffer sb = new StringBuffer();
        int sscos1 = 0;
        for (int i = 0; i < 4; i++) {
//            System.out.println(i + "次判断");
            JSONObject message3 = JSONObject.fromObject(message1.get(i));
//            System.out.println("currentSsc:" + message3);
            Object message4 = message3.get("os");
            if (i == 0) {
                sscos1 = Integer.parseInt(message4.toString());
            }
            System.out.println("期数：" + sscos1);
            Object message5 = message3.get("r");
            sscr = message5.toString();
            String sscr1 = sscr.substring(6);
            System.out.println("后两位：" + sscr1);
            boolean flg = false;
            for (int j = 0; j < baohan.length; j++) {
                if (sscr1.contains(baohan[j])) {
//                    System.out.println(i + "次包含");
                    flg = true;
                }
            }
            if (flg) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        System.out.println("序列值：" + sb);
        if (StringUtils.equals(String.valueOf(sb), "1100") || StringUtils.equals(String.valueOf(sb), "1101")) {
            if (sscos == sscos1) {
                return false;
            }
            sscos = sscos1;
            return true;
        }
        return false;
    }

    public boolean xiadan() {
        int cha = abc;
        while (true) {
            try {
                PostMethod postMethod = null;
                postMethod = new PostMethod(danUrl);
                postMethod.setRequestHeader("cookie", cookie);
                postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                postMethod.setRequestHeader("Origin", origin);
                postMethod.setRequestHeader("referer", referer);
                postMethod.setRequestHeader("x-requested-with", "XMLHttpRequest");
                StringBuffer orders = new StringBuffer();
                orders.append("{\"orders\":\"2S124578_124578.\",\"draws\":[{\"draw\":{\"id\":\"")
                        .append(cha)
                        .append("\"},\"multiply\":\"1\"},{\"draw\":{\"id\":\"")
                        .append(cha + 1)
                        .append("\"},\"multiply\":\"1\"},{\"draw\":{\"id\":\"")
                        .append(cha + 2)
                        .append("\"},\"multiply\":\"1\"},{\"draw\":{\"id\":\"")
                        .append(cha + 3)
                        .append("\"},\"multiply\":\"1\"},{\"draw\":{\"id\":\"")
                        .append(cha + 4)
                        .append("\"},\"multiply\":\"1\"},{\"draw\":{\"id\":\"")
                        .append(cha + 5)
                        .append("\"},\"multiply\":\"1\"},{\"draw\":{\"id\":\"")
                        .append(cha + 6)
                        .append("\"},\"multiply\":\"1\"},{\"draw\":{\"id\":\"")
                        .append(cha + 7)
                        .append("\"},\"multiply\":\"1\"},{\"draw\":{\"id\":\"")
                        .append(cha + 8)
                        .append("\"},\"multiply\":\"1\"}],\"flag\":[\"N\"],\"isCno\":true,\"prize\":1920,\"unit\":4,\"rebate\":0,\"cnoSetting\":\"W\",\"whichClientType\":\"PC\"}");
                NameValuePair[] data = {
                        new NameValuePair("order", orders.toString()),
                };
                postMethod.setRequestBody(data);
                org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();
                httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(3000);
                httpClient.getHttpConnectionManager().getParams().setSoTimeout(3000);
                int response = 0;// 执行POST方法
                InputStream inputStream = null;
                StringBuffer result = new StringBuffer();
                response = httpClient.executeMethod(postMethod);
                System.out.println("response:" + response);
                if (response == 200) {
                    inputStream = postMethod.getResponseBodyAsStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                    String str = "";
                    while ((str = br.readLine()) != null) {
                        result.append(str);
                    }
                    JSONObject message = JSONObject.fromObject(result.toString());
                    System.out.println("message:" + message);
                    if (message.get("code").toString().equals("1")) {
                        return true;
                    } else {
                        System.out.println("下单返回失败！");
                        return false;
                    }
                } else {
                    System.out.println("下单连接失败！");
                    return false;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean bianma() {
        while (true) {
            try {
                PostMethod postMethod = null;
                postMethod = new PostMethod(maUrl);
                postMethod.setRequestHeader("cookie", cookie);
                postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                postMethod.setRequestHeader("Origin", origin);
                postMethod.setRequestHeader("referer", referer);
                postMethod.setRequestHeader("x-requested-with", "XMLHttpRequest");
                NameValuePair[] data = {
                        new NameValuePair("siteCode", "HELSSC1"),
                };
                postMethod.setRequestBody(data);
                org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();
                httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(3000);
                httpClient.getHttpConnectionManager().getParams().setSoTimeout(3000);
                int response = 0;// 执行POST方法
                InputStream inputStream = null;
                StringBuffer result = new StringBuffer();
                response = httpClient.executeMethod(postMethod);
                System.out.println("response:" + response);
                if (response == 200) {
                    inputStream = postMethod.getResponseBodyAsStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                    String str = "";
                    while ((str = br.readLine()) != null) {
                        result.append(str);
                    }
                    JSONObject message = JSONObject.fromObject(result.toString());
                    System.out.println("message:" + message);
                    if (message.get("code").toString().equals("-1")) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            continue;
                        }
                        continue;
                    }
                    if (message.get("code").toString().equals("1")) {
                        JSONObject message1 = JSONObject.fromObject(message.get("message"));
                        Object cdId = message1.get("cdId");
                        abc = Integer.parseInt(cdId.toString());
                        System.out.println("编码：" + abc);
                        return true;
                    } else {
                        System.out.println("编码返回失败！");
                        return false;
                    }
                } else {
                    System.out.println("编码连接失败！");
                    return false;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

