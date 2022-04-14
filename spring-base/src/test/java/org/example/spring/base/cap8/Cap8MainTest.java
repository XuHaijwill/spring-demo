package org.example.spring.base.cap8;

import org.example.spring.base.cap8.config.Cap8MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import static org.junit.Assert.*;

public class Cap8MainTest {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap8MainConfig.class);
        //从容器中获取所有bean
        String[] names = app.getBeanDefinitionNames();

        for(String name:names){
            System.out.println(name);
        }
        com.enjoy.cap8.bean.Bird bird = (com.enjoy.cap8.bean.Bird) app.getBean("bird");

        System.out.println(bird);
        System.out.println("IOC容器创建完成........");



        ConfigurableEnvironment environment = app.getEnvironment();
        System.out.println("environment===="+environment.getProperty("bird.color"));
        app.close();





    }
}