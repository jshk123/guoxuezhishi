package com.guoxuezhishi.game;

import org.junit.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * @author: jiang
 * @date: 2019/10/30
 */
public class RobotTest {

    @Test
    //单击键盘
    public void test1() throws AWTException {
        Robot robot = new Robot();
        robot.delay(3000);
        for (int i = 0; i < 10; i++) {
            robot.keyPress(KeyEvent.VK_Q);
            robot.delay(200);
            robot.keyRelease(KeyEvent.VK_Q);
            robot.delay(400);
        }
    }

    @Test
    //单击鼠标
    public void test2() throws AWTException {
        Robot robot = new Robot();
        robot.delay(3000);
        for (int i = 0; i < 2; i++) {
            robot.mouseMove(1800, 1046);
            robot.delay(200);
            robot.mousePress(KeyEvent.BUTTON1_MASK);
            robot.delay(200);
            robot.mouseRelease(KeyEvent.BUTTON1_MASK);
            robot.delay(2000);
        }
    }

    @Test
    //获取图像属性，及鼠标坐标
    public void test3() throws AWTException {
        Robot robot = new Robot();
        robot.delay(3000);
        for (int i = 0; i < 2; i++) {
            robot.mouseMove(1800, 1046);
            robot.delay(200);
            Color pixelColor = robot.getPixelColor(1800, 1046);
            double x = MouseInfo.getPointerInfo().getLocation().getX();
            double y = MouseInfo.getPointerInfo().getLocation().getY();
            System.out.println(i + ":" + pixelColor.getBlue() + "-" + pixelColor.getGreen() + "-" + pixelColor.getRed() + "-" + pixelColor.getRGB() + "-" + x + "+" + y);
            robot.delay(200);
            robot.mouseRelease(KeyEvent.BUTTON1_MASK);
            robot.delay(2000);
        }
    }

    @Test
    public void wow() throws AWTException {
        Robot robot = new Robot();
        Random random = new Random();
        robot.delay(5000);
        int i = 0;
        while (true) {
            i++;
            //选择目标并施放技能
            robot.keyPress(KeyEvent.VK_7);
            robot.delay(200+random.nextInt()* 100);
            robot.keyRelease(KeyEvent.VK_7);
            robot.delay(400+random.nextInt()* 100);
            //旋转视野
            if (random.nextInt() * 100 > 50) {
                robot.keyPress(KeyEvent.VK_E);
                robot.delay(200 + random.nextInt() * 100);
                robot.keyRelease(KeyEvent.VK_E);
            } else {
                robot.keyPress(KeyEvent.VK_Q);
                robot.delay(200+random.nextInt()* 100);
                robot.keyRelease(KeyEvent.VK_Q);
            }
            robot.delay(400+random.nextInt()* 100);
            //判断血条，并施放技能
            Color pixelColor = robot.getPixelColor(10, 10);
            double x = MouseInfo.getPointerInfo().getLocation().getX();
            double y = MouseInfo.getPointerInfo().getLocation().getY();
            System.out.println("第"+i+"次执行：" + pixelColor.getBlue() + "-" + pixelColor.getGreen() + "-" + pixelColor.getRed() + "-" + pixelColor.getRGB() + "-" + x + "+" + y);
            robot.delay(200);
            robot.mouseRelease(KeyEvent.BUTTON1_MASK);
            robot.delay(2000);

        }


    }
}