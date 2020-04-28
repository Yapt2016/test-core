package com.yapt.demo.test.core.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hurui
 * @version Id: Application.java, v 0.1 2020/1/8 16:55 YaphetS Exp $$
 */
@MapperScan("com.yapt.demo.test.core.dao.mapper")
@SpringBootApplication(scanBasePackages = "com.yapt.demo")
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
