package com.demo.service;

import com.spring.BeanPostProcessor;

import java.lang.reflect.Field;

public class DemoValueBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {

        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(DemoValue.class)) {
                field.setAccessible(true);
                try {
                    field.set(bean, field.getAnnotation(DemoValue.class).value());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // bean
        return bean;
    }
}
