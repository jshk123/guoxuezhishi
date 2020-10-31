package com.guoxuezhishi.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)//元注解，标记该注解作用范围
@Retention(RetentionPolicy.RUNTIME)////元注解，标记该注解生命周期
@Documented //元注解，标记生成javadoc时解释说明该注解
public @interface RequstType {

    //用枚举指定请求类型
    enum Type {GET, POST};

    //返回类型是Type中的一个，默认是GET
    Type value() default Type.POST;
}
