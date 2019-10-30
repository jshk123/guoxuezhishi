package com.guoxuezhishi.game;

import javax.swing.*;

/**
 * @author: jiang
 * @date: 2019/10/28
 */
public class Snake {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
//      框体大小
        frame.setBounds(400, 200, 900, 720);
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
