package com.guoxuezhishi.game;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author: jiang
 * @date: 2019/11/18
 * 客户端窗体
 */
public class ClientWindow extends JFrame {
    private ObjectOutputStream oos;
    private JLabel label;

    //重写背景图片方法
    public void repainImage(byte[] imageBytes) {
        label.setIcon(new ImageIcon(imageBytes));
        this.repaint();
    }

    public ClientWindow(ObjectOutputStream oos) {
        this.oos = oos;
        this.setTitle("远程控制程序");
        label = new JLabel();
        JPanel p = new JPanel();
        p.add(label);
        //给p面板添加滚动条
        JScrollPane scroll = new JScrollPane(p);
        this.add(scroll);
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                sendEvent(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                sendEvent(e);
            }
        });
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sendEvent(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                sendEvent(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                sendEvent(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                sendEvent(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sendEvent(e);
            }
        });
    }

    public void sendEvent(InputEvent event) {
        try {
            oos.writeObject(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
