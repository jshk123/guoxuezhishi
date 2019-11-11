package com.guoxuezhishi.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * @author: jiang
 * @date: 2019/10/29
 */
public class SnakePanel extends JPanel implements KeyListener, ActionListener {

    //    加载图片
    ImageIcon up = new ImageIcon(this.getClass().getResource("/pic/up.png"));
    ImageIcon down = new ImageIcon(this.getClass().getResource("/pic/down.png"));
    ImageIcon left = new ImageIcon(this.getClass().getResource("/pic/left.png"));
    ImageIcon right = new ImageIcon(this.getClass().getResource("/pic/right.png"));
    ImageIcon title = new ImageIcon(this.getClass().getResource("/pic/title.jpg"));
    ImageIcon food = new ImageIcon(this.getClass().getResource("/pic/food.png"));
    ImageIcon body = new ImageIcon(this.getClass().getResource("/pic/body.png"));

    // 蛇的数据结构的设计
    int[] snakex = new int[750];
    int[] snakey = new int[750];
    int len = 3;
    // R右  L左  U上  D下
    String direction = "R";

    //游戏是否开始
    boolean isStarted = false;
    //    游戏是否失败
    boolean isFailed = false;
    //定时器
    Timer timer = new Timer(150, this);

    //食物的数据
    Random random = new Random();
    int foodx = random.nextInt(34) * 25 + 25;
    int foody = random.nextInt(24) * 25 + 75;

    //    统计分数
    int score = 0;

    //构造函数
    public SnakePanel() {
        this.setFocusable(true);
        //放置静态蛇
        initSnake();
//        添加键盘监听接口
        this.addKeyListener(this);
        timer.start();

    }

    //初始化蛇
    public void initSnake() {
        isStarted = false;
        isFailed = false;
        len = 3;
        direction = "R";
        snakex[0] = 100;
        snakey[0] = 100;
        snakex[1] = 75;
        snakey[1] = 100;
        snakex[2] = 50;
        snakey[2] = 100;

    }

    public void paint(Graphics graphics) {

//        设置画布的背景颜色
        this.setBackground(Color.black);
        graphics.fillRect(25, 75, 850, 600);
//        设置标题
        title.paintIcon(this, graphics, 25, 11);
//        画蛇头
        if (direction.equals("R")) {
            right.paintIcon(this, graphics, snakex[0], snakey[0]);
        } else if (direction.equals("L")) {
            left.paintIcon(this, graphics, snakex[0], snakey[0]);

        } else if (direction.equals("U")) {
            up.paintIcon(this, graphics, snakex[0], snakey[0]);

        } else if (direction.equals("D")) {
            down.paintIcon(this, graphics, snakex[0], snakey[0]);

        }
//        画蛇身
        for (int i = 1; i < len; i++) {
            body.paintIcon(this, graphics, snakex[i], snakey[i]);
        }
//        画食物
        food.paintIcon(this, graphics, foodx, foody);

//        画开始提示语
        if (!isStarted) {
            graphics.setColor(Color.white);
            graphics.setFont(new Font("arial", Font.BOLD, 30));
            graphics.drawString("Press Space to Start/Pause", 300, 300);

        }
        //        画失败提示语
        if (isFailed) {
            graphics.setColor(Color.white);
            graphics.setFont(new Font("arial", Font.BOLD, 30));
            graphics.drawString("Game over! Press Space to Start/Pause", 300, 300);

        }
//分数和长度的统计
        graphics.setColor(Color.green);
        graphics.setFont(new Font("arial", Font.PLAIN, 15));
        graphics.drawString("Score: " + score, 750, 30);
        graphics.drawString("Length: " + len, 750, 50);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            if (isFailed) {
                initSnake();
            } else {
                isStarted = !isStarted;
            }
        } else if (keyCode == KeyEvent.VK_UP && !direction.equals("D")) {
            direction = "U";
        } else if (keyCode == KeyEvent.VK_DOWN && !direction.equals("U")) {
            direction = "D";
        } else if (keyCode == KeyEvent.VK_LEFT && !direction.equals("R")) {
            direction = "L";
        } else if (keyCode == KeyEvent.VK_RIGHT && !direction.equals("L")) {
            direction = "R";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * 定时器实现
     * 1.重新定个闹钟
     * 2.蛇移动
     * 3.重画
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        //游戏开始
        if (isStarted && !isFailed) {
//            移动身体
            for (int i = len; i > 0; i--) {
                snakex[i] = snakex[i - 1];
                snakey[i] = snakey[i - 1];

            }
//            头移动
            if (direction.equals("R")) {
                //横坐标+25
                snakex[0] = snakex[0] + 25;
                if (snakex[0] > 850) {
                    snakex[0] = 25;
                }

            } else if (direction.equals("L")) {
                //横坐标-25
                snakex[0] = snakex[0] - 25;
                if (snakex[0] < 25) {
                    snakex[0] = 850;
                }
            } else if (direction.equals("U")) {
                //纵坐标-25
                snakey[0] = snakey[0] - 25;
                if (snakey[0] < 75) {
                    snakey[0] = 650;
                }
            } else if (direction.equals("D")) {
                //纵坐标+25
                snakey[0] = snakey[0] + 25;
                if (snakey[0] > 650) {
                    snakey[0] = 75;
                }
            }
            //        吃食物的逻辑
            if (snakex[0] == foodx && snakey[0] == foody) {
                len++;
                score++;
                foodx = random.nextInt(34) * 25 + 25;
                foody = random.nextInt(24) * 25 + 75;
            }
            //判断游戏失败的逻辑
            for (int i = 1; i < len; i++) {
                if (snakex[0] == snakex[i] && snakey[0] == snakey[i]) {
                    isFailed = true;
                }
            }
        }

        repaint();
    }
}
