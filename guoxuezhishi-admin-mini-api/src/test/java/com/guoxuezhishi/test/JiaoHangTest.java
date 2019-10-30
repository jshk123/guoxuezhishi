package com.guoxuezhishi.test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author: jiang
 * @date: 2019/7/23
 */
public class JiaoHangTest {
    public static final String DEFAULT_CHARSET = "GBK";

    public static void main(String[] args) throws Exception {
//        String head = "<tr_code>310204</tr_code><corp_no>0008000041</corp_no><user_no>00002</user_no><req_no>00010239</req_no><tr_acdt>20061206</tr_acdt><tr_time>100108</tr_time><atom_tr_count>1</atom_tr_count><channel>0</channel><reserved></reserved>";
        String head = "<tr_code>710713</tr_code><corp_no>8000142509</corp_no><user_no>00001</user_no><req_no>00010239</req_no><tr_acdt>20190711</tr_acdt><tr_time>100108</tr_time><atom_tr_count>1</atom_tr_count><channel>0</channel><reserved></reserved>";
        System.out.println("head:" + head);
//        String body = "<query_flag>2</query_flag><ogl_serial_no>2011000420150228143644046402</ogl_serial_no>";
//        String body = "<insideAccrual>0</insideAccrual><superAcc>4444</superAcc><cloudAccName>2222</cloudAccName><Acc>3333</Acc><printReceipt>0</printReceipt><takeOutSign>0</takeOutSign><way>2</way><cdCloseCircle>0</cdCloseCircle><tranType>0</tranType><cloudAcc>11111</cloudAcc><sealShared>0</sealShared><certShared>0</certShared>";
//        String body = "<inside_accrual>0</inside_accrual><super_acc>4444</super_acc><cloud_acc_name>2222</cloud_acc_name><acc>3333</acc><print_receipt>0</print_receipt><take_out_sign>0</take_out_sign><way>2</way><cd_close_circle>0</cd_close_circle><tran_type>0</tran_type><cloud_acc>11111</cloud_acc><seal_shared>0</seal_shared><cert_shared>0</cert_shared>";
        String body = "<data>00000173BJETC|^|^|^|^|^|^|^|^|^710713|^1|^110060974018002562959|^110060974018002562959|^|^81100614850180101000029|^测试有限公司|^测试有限公司别名|^|^0|^0|^|^2|^0|^0|^1|^0|^|^|^|^0|^</data><rem></rem>";
        System.out.println("body:" + body);
        doSocket(head, body);
    }

    public static String doSocket(String headMsg, String bodyMsg) throws Exception {
/*        System.out.println("建立socket。。。");
        int soTimeOut = 5000;
        Socket socket = new Socket("182.119.148.170", 7777);
        System.out.println("超时设置5s");
        socket.setSoTimeout(soTimeOut);*/

        System.out.println("建立socket。。。");
        int soTimeOut = 5000;
        Socket socket = new Socket("172.20.12.184", 30010);
        System.out.println("超时设置5s");
        socket.setSoTimeout(soTimeOut);
        System.out.println("组装数据。。。");
        BufferedOutputStream wr = null;
        String head = "<head>" + headMsg + "</head>";
        System.out.println("headMsg:" + head);
        String body = "<body>" + bodyMsg + "</body>";
        System.out.println("bodyMsg:" + body);
        String message = "<ap>" + head + body + "</ap>";
        System.out.println("sendMsg:" + message);
        System.out.println("先转换成 GBK 的 byte 数组");
        byte[] messageByte = message.getBytes(DEFAULT_CHARSET);
        System.out.println("messageByte:" + messageByte);
        System.out.println("messageByte.length:" + messageByte.length);
        String length = "0" + messageByte.length + "           ";
        System.out.println("length:" + length);
        System.out.println("7 位头");
        length = length.substring(0, 7);
        System.out.println("new length:" + length);
        message = length + message;
        System.out.println("new message:" + message);
        messageByte = message.getBytes(DEFAULT_CHARSET);
        System.out.println("new messageByte:" + messageByte);

        int sleepTime = 1000;
        try {
            System.out.println("1s，线程休眠时间");
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            System.out.println("线程异常！");
        }

        System.out.println("开始发送消息");
        wr = new BufferedOutputStream(socket.getOutputStream());
        wr.write(messageByte);
        wr.flush();
        System.out.println("接收回应消息");
        BufferedReader rd = new BufferedReader(new
                InputStreamReader(socket.getInputStream(), DEFAULT_CHARSET));
        String line = null;
        StringBuffer sb = new StringBuffer();
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        System.out.println("处理返回");
        String returnStr = new String(sb.toString().getBytes());
        wr.close();
        rd.close();
        socket.close();
        System.out.println("======" + returnStr);
        return returnStr;
    }
}

