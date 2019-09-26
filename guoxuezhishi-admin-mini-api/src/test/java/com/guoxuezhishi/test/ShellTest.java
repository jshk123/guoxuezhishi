package com.guoxuezhishi.test;

import net.sf.json.JSONObject;
import org.junit.Test;

/**
 * @author: jiang
 * @date: 2019/9/11
 */
public class ShellTest {
    @Test
    public void shell() {
        JSONObject result = new JSONObject();
        String osname = System.getProperty("os.name");
        if (osname != null && (osname.toLowerCase().startsWith("win"))) {
            result.put("code", "0");
            result.put("msg", "当前服务器操作系统不是linux");
            System.out.println(result.toString());
        }

    }

}
