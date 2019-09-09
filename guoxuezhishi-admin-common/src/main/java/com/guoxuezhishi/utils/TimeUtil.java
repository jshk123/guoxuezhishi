package com.guoxuezhishi.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: jiang
 * @date: 2019/9/9
 */
public class TimeUtil {
    public static String getdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dt = sdf.format(new Date());
        return dt;
    }

}
