package com.guoxuezhishi.game;

import javax.swing.*;

/**
 * @author: jiang
 * @date: 2019/10/28
 */
public class Snake {
    public static void main(String[] args) {
        System.out.println(Snake.class.getResource(""));
        System.out.println(Snake.class.getResource("/"));
        JFrame frame = new JFrame();
//      框体大小
//        frame.setBounds(400, 200, 900, 720);
        frame.setSize(900, 720);
//        设置框体居中
        frame.setLocationRelativeTo(null);
//      框体可否拉动
        frame.setResizable(false);
//      关闭后退出
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //       设置画布
        SnakePanel snakePanel = new SnakePanel();
        frame.add(snakePanel);

//      框体可见
        frame.setVisible(true);
    }
}
