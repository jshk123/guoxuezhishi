package com.guoxuezhishi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author: jiang
 * @date: 2019/5/20
 */
@SpringBootApplication
@MapperScan(basePackages = "com.guoxuezhishi.mapper")
@ComponentScan(basePackages = {"com.guoxuezhishi"})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}