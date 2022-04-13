package org.example.spring.base.cap5;

import org.example.spring.base.cap5.config.Cap5MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class Cap5MainTest {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap5MainConfig.class);

        System.out.println("IOC容器创建完成........");


    }
}