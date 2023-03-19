package com.shardingjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ShardingJdbcApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ShardingJdbcApp.class, args);
    }
}
