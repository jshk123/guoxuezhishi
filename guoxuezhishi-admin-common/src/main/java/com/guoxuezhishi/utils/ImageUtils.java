package com.guoxuezhishi.utils;

import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author: jiang
 * @date: 2019/7/30
 */
public class ImageUtils {
    /**
     * @Description: 该方法的主要作用：本地图片转换成Base64图像格式的方法
     */
    public static String ImageToBase64(String imgPath) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgPath);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //进行编码
        BASE64Encoder encoder = new BASE64Encoder();
        //返回编码完成的base64图像数据
        return encoder.encode(data);
    }
}
