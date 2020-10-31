package com.guoxuezhishi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author: jiang
 * @date: 2019/5/20
 */
@SpringBootApplication
@MapperScan(basePackages = "com.guoxuezhishi.mapper")
@ComponentScan(basePackages = {"com.guoxuezhishi"})
@Slf4j
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        long duration = System.currentTimeMillis() - start;
        log.info("启动时长：" + (duration / 1000) + "秒");
        log.info("访问地址：localhost:{}/doc.html", run.getEnvironment().getProperty("server.port"));
    }

}