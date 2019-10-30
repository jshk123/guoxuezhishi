package com.guoxuezhishi.test;

/**
 * @author: jiang
 * @date: 2019/10/21
 * 单例设计模式
 */
public class DanlimoshiTest {
    public static void main(String[] args) {
        StudentA.getInstance();
        StudentB.getInstance();
    }
}

class StudentA {
    private StudentA() {
        System.out.println("饿汉式单例模式！");
    }

    private static final StudentA s = new StudentA();

    public static StudentA getInstance() {
        return s;
    }
}

class StudentB {
    private StudentB() {
        System.out.println("懒汉式单例模式！");
    }

    private static StudentB s;

    public static StudentB getInstance() {
        if (s == null) {
            //线程1就进来了，线程2就进来了。
            s = new StudentB();
        }
        return s;
    }
}