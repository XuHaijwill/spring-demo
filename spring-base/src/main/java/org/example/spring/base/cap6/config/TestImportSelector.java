package org.example.spring.base.cap6.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


public class TestImportSelector implements ImportSelector{
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata){
		//返回全类名的bean
		return new String[]{"org.example.spring.base.cap6.bean.Fish","org.example.spring.base.cap6.bean.Tiger"};
	}
}

