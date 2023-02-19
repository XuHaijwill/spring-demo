package com.demo;

import com.demo.service.UserInterface;
import com.spring.DemoApplicationContext;

public class Test {

    public static void main(String[] args) {

        // 扫描--->创建单例Bean BeanDefinition BeanPostPRocess
        DemoApplicationContext applicationContext = new DemoApplicationContext(AppConfig.class);

        UserInterface userService = (UserInterface) applicationContext.getBean("userService");
        userService.test();
    }

}
