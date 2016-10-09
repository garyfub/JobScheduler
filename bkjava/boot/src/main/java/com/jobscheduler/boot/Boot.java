package com.jobscheduler.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Boot :
 *
 * @author wuhuachuan712@163.com
 * @date 16/10/9
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.jobscheduler.*" })
@MapperScan(basePackages = { "com.jobscheduler.dashboard.dao" })
public class Boot {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Boot.class, args);
    }
}
