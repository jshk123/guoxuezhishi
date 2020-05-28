package com.guoxuezhishi.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class test1 {
    /**
     * 无参无返回值
     */
    @Test
    public void t1() {
        int num = 0;

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world  " + num);
            }
        };
        r.run();
        System.out.println("--------------------------");
        Runnable r1 = () -> System.out.println("hello lanmda  " + num);
        r1.run();
    }

    /**
     * 有一个参无返回值
     */
    @Test
    public void t2() {
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("hello  abc");
    }

    /**
     * 有一个参无返回值  省略括号
     */
    @Test
    public void t3() {
        Consumer<String> con = x -> System.out.println(x);
        con.accept("hello  abc");
    }

    /**
     * 有两个以上参 有返回值 多条语句
     */
    @Test
    public void t4() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("两个参数");
            return Integer.compare(x, y);
        };
    }

    /**
     * 有两个以上参 有返回值 一条语句
     */
    @Test
    public void t5() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

    }

    @Test
    public void t6() {
        Integer num = operation(100, (x) -> x * x);
        System.out.println(num);

        Integer num2 = operation(100, (x) -> x + 200);
        System.out.println(num2);
    }

    public Integer operation(Integer num, MyFun myFun) {
        return myFun.getValue(num);
    }
}
