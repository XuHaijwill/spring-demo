package org.example.spring.base.cap10;

import org.example.spring.base.cap10.aop.Calculator;
import org.example.spring.base.cap10.config.Cap10MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class Cap10MainTest {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap10MainConfig.class);

        //Calculator c = new Calculator();
        Calculator c = app.getBean(Calculator.class);
        int result = c.div(4, 3);
        System.out.println(result);
        app.close();


    }
}