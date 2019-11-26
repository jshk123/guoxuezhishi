package com.guoxuezhishi.game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author: jiang
 * @date: 2019/11/18
 */
public class LocalScreen {

    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        JFrame frame = new JFrame();
        JLabel jLabel = new JLabel();
        frame.add(jLabel);
        frame.setSize(700, 500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        while (true) {
            BufferedImage screenCapture = robot.createScreenCapture(new Rectangle(100, 100, 700, 500));
            jLabel.setIcon(new ImageIcon(screenCapture));
            Thread.sleep(50);

        }

    }

}
