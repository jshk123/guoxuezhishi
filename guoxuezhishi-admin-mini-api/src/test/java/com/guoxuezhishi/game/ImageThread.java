package com.guoxuezhishi.game;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author: jiang
 * @date: 2019/11/18
 * 将图片数据发送
 * 屏幕截取器和发送器，这里需要拿到socket的out流
 */
public class ImageThread implements Runnable {
    //数据输出流
    DataOutputStream dos = null;

    public ImageThread(DataOutputStream dos) {
        this.dos = dos;
    }

    @Override
    public void run() {

        try {
            Robot robot = new Robot();
            //获取整个屏幕
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle rec = new Rectangle(dimension);
            BufferedImage image;
            byte imageBytes[];
            while (true) {
                image = robot.createScreenCapture(rec);
                imageBytes = getImageBytes(image);
                dos.writeInt(imageBytes.length);
                dos.write(imageBytes);
                dos.flush();
                //线程睡眠
                Thread.sleep(50);

            }

        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 压缩图片
     *
     * @param image 需要压缩的图片
     * @return 压缩后的byte数组
     * @throws IOException
     * @throws IOException
     */
    public byte[] getImageBytes(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //压缩器压缩，先拿到存放到byte输出流中
        JPEGImageEncoder jpegd = JPEGCodec.createJPEGEncoder(baos);
        //将iamge压缩
        jpegd.encode(image);
        //转换成byte数组
        return baos.toByteArray();
    }
}
