package com.guoxuezhishi.game;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: jiang
 * @date: 2019/11/18
 * 处理接收的鼠标和键盘事件
 */
public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(80);
        System.out.println("服务器已经正常启动，等待客户连接");
        //等待接收请求,阻塞方法
        Socket socket = server.accept();
        System.out.println("客户已连接");
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        //将客户端与服务器端链接的输出流交个ImageThread处理
        ImageThread imageThread = new ImageThread(dos);
        new Thread(imageThread).start();
        new Thread(new EventThread(new ObjectInputStream(socket.getInputStream()))).start();

    }
}
