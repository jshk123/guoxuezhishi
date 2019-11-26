package com.guoxuezhishi.game;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author: jiang
 * @date: 2019/11/18
 */
public class EventThread implements Runnable {
    private ObjectInputStream ois;
    private Robot robot;

    public EventThread(ObjectInputStream ois) {
        this.ois = ois;
    }

    @Override
    public void run() {
        try {
            robot = new Robot();
            while (true) {
                //得知由客户端传递过来的是一个object对象
                InputEvent event = (InputEvent) ois.readObject();
                //处理事件
                actionEvent(event);
            }
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 事件处理，用来判断事件类型，并用robot类执行
     */
    public void actionEvent(InputEvent event) {
        System.out.println(event);
        if (event instanceof KeyEvent) {
            KeyEvent e = (KeyEvent) event;
            //拿到事件类型
            int type = e.getID();
            if (type == Event.KEY_PRESS) {
                robot.keyPress(e.getKeyCode());
            } else if (type == Event.KEY_RELEASE) {
                robot.keyRelease(e.getKeyCode());
            }
        } else if (event instanceof MouseEvent) {
            MouseEvent e = (MouseEvent) event;
            int type = e.getID();
            if (type == Event.MOUSE_MOVE) {
                robot.mouseMove(e.getX(), e.getY());
            } else if (type == Event.MOUSE_DOWN) {
                robot.mousePress(getMouseKey(type));
            } else if (type == Event.MOUSE_UP) {
                robot.mouseRelease(getMouseKey(type));
            } else if (type == Event.MOUSE_DRAG) {
                //鼠标拖动
                robot.mouseMove(e.getX(), e.getY());
            }
        }
    }

    /**
     * 返回鼠标的真正事件，鼠标时间不能直接处理，需要进过转换
     */
    public int getMouseKey(int button) {
        if (button == MouseEvent.BUTTON1) {//鼠标左键
            return InputEvent.BUTTON1_MASK;
        } else if (button == MouseEvent.BUTTON2) {//鼠标右键
            return InputEvent.BUTTON2_MASK;
        } else if (button == MouseEvent.BUTTON3) {//滚轮
            return InputEvent.BUTTON3_MASK;
        } else {
            return 0;
        }
    }
}
