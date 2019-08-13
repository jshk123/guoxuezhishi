package com.guoxuezhishi.queue;

import java.util.Scanner;

/**
 * @author: jiang
 * @date: 2019/8/11
 * 数组模拟队列（不能复用）
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        //创建队列对象
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show):显示菜单");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);//接受一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g'://取出数据
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h'://查看数据头
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("取出的头数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }
            System.out.println("程序退出");

        }
    }
}

class ArrayQueue {
    private int maxSize;
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部，队列头部的前一个位置
        rear = -1;//指向队列尾部，队列尾部的具体位置
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数列到队列
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加数据");
            return;
        }
        rear++;//让rear后移
        arr[rear] = n;
    }

    //获取队列数据
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //通过抛出异常处理
            throw new RuntimeException("队列为空，不能取出数据");
        }
        front++;//front后移
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历数组
        if (isEmpty()) {
            System.out.println("空队列，无数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列的头数据，不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，无数据");
        }
        return arr[front + 1];
    }
}
