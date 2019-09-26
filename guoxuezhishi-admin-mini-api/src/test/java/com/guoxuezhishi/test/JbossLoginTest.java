package com.guoxuezhishi.test;

import org.jboss.resource.security.SecureIdentityLoginModule;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: jiang
 * @date: 2019/9/17
 */
public class JbossLoginTest {
    public static void setObjectColor(Object obj) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class cls = obj.getClass();
        //获得类的私有方法
        Method method = cls.getDeclaredMethod("encode", String.class);
        method.setAccessible(true); //没有设置就会报错
        //调用该方法
        String igw = String.valueOf(method.invoke(obj, "igw"));
        System.out.println(igw);
    }

    public static void main(String args[]) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        setObjectColor(new SecureIdentityLoginModule());
    }
}

