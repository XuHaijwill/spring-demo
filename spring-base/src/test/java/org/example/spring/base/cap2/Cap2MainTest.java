package org.example.spring.base.cap2;

import org.example.spring.base.cap2.config.Cap2MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Cap2MainTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap2MainConfig.class);

        String[] names = app.getBeanDefinitionNames();

        for(String name:names){
            System.out.println(name);
        }
    }
}