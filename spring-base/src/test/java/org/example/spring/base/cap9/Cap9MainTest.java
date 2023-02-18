package org.example.spring.base.cap9;

import org.example.spring.base.cap9.bean.Moon;
import org.example.spring.base.cap9.bean.Sun;
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

    @Test
    public void test02(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap9MainConfig.class);
        System.out.println(app);

		Moon moon = (Moon)app.getBean(Moon.class);
		System.out.println(moon);

		Sun sun = (Sun)app.getBean(Sun.class);
		System.out.println(sun.getMoon());

        app.close();
    }
}
