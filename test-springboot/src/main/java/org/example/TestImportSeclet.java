package org.example;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * DeferredImportSelector
 *
 * 1. DeferredImportSelector是ImportSelector的一个扩展；
 * 2. ImportSelector实例的selectImports方法的执行时机，是在@Configguration注解中的其他逻辑被处理之前，所谓的其他逻辑，包括对@ImportResource、@Bean这些注解的处理（注意，这里只是对@Bean修饰的方法的处理，并不是立即调用@Bean修饰的方法，这个区别很重要！）；
 * 3. DeferredImportSelector实例的selectImports方法的执行时机，是在@Configguration注解中的其他逻辑被处理完毕之后，所谓的其他逻辑，包括对@ImportResource、@Bean这些注解的处理；
 * 4. DeferredImportSelector的实现类可以用Order注解，或者实现Ordered接口来对selectImports的执行顺序排序；
 * 原文链接：https://blog.csdn.net/boling_cavalry/article/details/82555352
 */
public class TestImportSeclet implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        // 自动配置

        ServiceLoader<AutoConfiguration> loader = ServiceLoader.load(AutoConfiguration.class);

        List<String> list = new ArrayList<>();

        for (AutoConfiguration configuration : loader) {
            list.add(configuration.getClass().getName());
        }

        return list.toArray(new String[0]);
    }
}
