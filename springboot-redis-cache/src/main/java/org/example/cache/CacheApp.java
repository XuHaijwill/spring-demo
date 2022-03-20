package org.example.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("org.example.cache.dao")
public class CacheApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CacheApp.class, args);
    }
}
