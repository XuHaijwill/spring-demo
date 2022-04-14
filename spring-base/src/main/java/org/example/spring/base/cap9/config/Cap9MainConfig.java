package org.example.spring.base.cap9.config;

import org.example.spring.base.cap9.dao.TestDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;



@Configuration
@ComponentScan({"org.example.spring.base.cap9.controller","org.example.spring.base.cap9.service","org.example.spring.base.cap9.dao"})
public class Cap9MainConfig {
	//spring进行自装配的时候默认首选的bean
	//@Primary
	@Bean("testDao")
	public TestDao testDao(){
		TestDao testDao = new TestDao();
		testDao.setFlag("2");
		return testDao;
	}
}

