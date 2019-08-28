package com.guoxuezhishi.queue;

import java.util.Scanner;

/**
 * @author: jiang
 * @date: 2019/8/11
 * 环形队列，留一个预留空间
 * 队列中有效个数： ( rear + maxSize - front) % maxSize
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        //创建队列对象
        //设置4 , 表示队列的最大有效数据为3
        CircleArray circleArray = new CircleArray(4);
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
                    circleArray.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    circleArray.addQueue(value);
                    break;
                case 'g'://取出数据
                    try {
                        int res = circleArray.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h'://查看数据头
                    try {
                        int res = circleArray.headQueue();
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
        }
        System.out.println("程序退出");
    }
}

class CircleArray {
    private int maxSize;//表示数组的最大容量
    //front 变量的含义：指向队列的第一个元素；
    // 初始值为0
    private int front;//队列头
    //rear 变量的含义：指向队列的最后一个元素的后一个位置；
    // 初始值为0
    private int rear;//队列尾
    private int[] arr;//模拟队列

    //创建队列的构造器
    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满：(rear + 1) % maxSize == front
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        //添加数据
        arr[rear] = n;
        //环形队列
        //将rear后移，(rear + 1) % maxSize
        rear = (rear + 1) % maxSize;
    }

    //获取队列数据
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //通过抛出异常处理
            throw new RuntimeException("队列为空，不能取出数据");
        }
        //这里的front 指向队列的第一个元素
        //1. 先把front 对应的值保存到一个临时变量
        //2. 将front 后移 考虑取模 (front + 1) % maxSize
        //3. 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历数组
        if (isEmpty()) {
            System.out.println("空队列，无数据");
            return;
        }
        //思路： 从front开始遍历，遍历多少个元素
        // 下标为 i % maxSize
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列有效个数
    public int size() {
        // rear = 0 front = 0  maxSize = 3 ---->0
        // rear =0  front =1  maxSize = 3 ----->2
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据，不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，无数据");
        }
        return arr[front];
    }
}
