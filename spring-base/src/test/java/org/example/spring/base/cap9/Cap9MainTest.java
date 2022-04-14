package org.example.spring.base.cap9;

import org.example.spring.base.cap9.config.Cap9MainConfig;
import org.example.spring.base.cap9.dao.TestDao;
import org.example.spring.base.cap9.service.TestService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;



public class Cap9MainTest {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap9MainConfig.class);

        TestService testService = app.getBean(TestService.class);
        testService.println();
        //直接从容器中获取TestDao, 和使用Autowired注解来取比较
        TestDao testDao = app.getBean(TestDao.class);
        System.out.println(testDao);

        app.close();





    }
}
