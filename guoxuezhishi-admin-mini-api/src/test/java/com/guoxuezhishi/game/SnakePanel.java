package com.guoxuezhishi.game;

import org.springframework.util.ResourceUtils;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.net.URL;

/**
 * @author: jiang
 * @date: 2019/10/29
 */
public class SnakePanel extends JPanel {
    //    加载图片
    ImageIcon up = new ImageIcon("src/pic/up.png");
    ImageIcon down = new ImageIcon("src/pic/down.png");
    ImageIcon left = new ImageIcon("src/pic/left.png");
    ImageIcon right = new ImageIcon("src/pic/right.png");
    ImageIcon title = new ImageIcon("src/pic/title.jpg");
    ImageIcon food = new ImageIcon("src/pic/food.png");
    ImageIcon body = new ImageIcon("src/pic/body.png");

    public void paint(Graphics graphics) {

//        设置画布的背景颜色
        this.setBackground(Color.black);
        graphics.fillRect(25, 75, 850, 600);
//        设置标题
        title.paintIcon(this, graphics, 25, 11);

    }

}
