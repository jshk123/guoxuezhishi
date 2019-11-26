package com.guoxuezhishi.game;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author: jiang
 * @date: 2019/11/18
 *  接收creen图片和发送鼠标和键盘事件
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 80);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        ClientWindow cw = new ClientWindow(oos);
        byte[] imageBytes;
        while (true) {
            //拿到传过来的数组，并将数据放到byte中
            imageBytes = new byte[dis.readInt()];
            dis.readFully(imageBytes);
            cw.repainImage(imageBytes);
        }

    }
}
