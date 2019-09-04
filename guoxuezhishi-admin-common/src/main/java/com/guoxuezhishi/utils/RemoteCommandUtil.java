package com.guoxuezhishi.utils;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * @author: jiang
 * @date: 2019/8/12
 */
public class RemoteCommandUtil {
    private static Logger logger = Logger.getLogger(SpringBootApplication.class);
    private static String DEFAULTCHART = "GBK";

    /**
     * 登陆linux
     *
     * @param ip
     * @param userName
     * @param userPwd
     * @return
     */
    public static Connection login(String ip, int port, String userName, String userPwd) {
        boolean flg = false;
        Connection conn = null;
        try {
            conn = new Connection(ip, port);
            conn.connect();
            flg = conn.authenticateWithPassword(userName, userPwd);
            if (flg) {
                logger.info("linux登陆成功");
                return conn;
            }
        } catch (IOException e) {
            logger.info("linux登陆失败");
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 远程执行命令
     *
     * @param conn
     * @param cmd  执行的命令
     * @return
     */
    public static String execute(Connection conn, String cmd) {
        String result = "";
        try {
            if (conn != null) {
                Session session = conn.openSession();//打开一个会话
                session.execCommand(cmd, DEFAULTCHART);//执行命令
                result = processStdout(session.getStdout(), DEFAULTCHART);
                //如果结果为空，则执行出错
                if (StringUtils.isBlank(result)) {
                    logger.info("得到标准输出为空,链接conn:" + conn + ",执行的命令：" + cmd);
                    result = processStdout(session.getStderr(), DEFAULTCHART);
                } else {
                    logger.info("执行命令成功,链接conn:" + conn + ",执行的命令：" + cmd + ",返回数据：" + result);
                }
                conn.close();
                session.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

    /**
     * 解析脚本执行返回的结果集
     *
     * @param in      输入流对象
     * @param charset
     * @return
     */
    private static String processStdout(InputStream in, String charset) {
        InputStream stdout = new StreamGobbler(in);
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout, charset));
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line + "\n");
            }
        } catch (UnsupportedEncodingException e) {
            logger.info("解析脚本出错" + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("解析脚本出错" + e.getMessage());
        }
        return buffer.toString();
    }

}
