package org.example.spring.base.cap4.config;

import org.example.spring.base.cap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class Cap4MainConfig {
    //给容器中注册一个bean, 类型为返回值的类型, 默认是单实例
    /*
     * 懒加载: 主要针对单实例bean:默认在容器启动的时候创建对象
     * 懒加载:容器启动时候不创建对象, 仅当第一次使用(获取)bean的时候才创建被初始化

     */
//    @Lazy
    @Bean
    public Person person(){
        System.out.println("给容器中添加person.......");
        return new Person("james",20);
    }
}