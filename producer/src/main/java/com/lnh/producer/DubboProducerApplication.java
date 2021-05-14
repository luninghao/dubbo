package com.lnh.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * 描述：     Spring Boot启动类
 */
@EnableAutoConfiguration
public class DubboProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProducerApplication.class, args);
    }
}
