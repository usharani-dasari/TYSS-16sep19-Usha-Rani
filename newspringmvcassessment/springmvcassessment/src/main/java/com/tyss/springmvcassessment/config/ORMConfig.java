package com.tyss.springmvcassessment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class ORMConfig {
	
	//LocalEntityManagerFactoryBean=>this class is present in spring orm dependency(we have added from google).It is used to create EntityManagerFactory
	@Bean
	public LocalEntityManagerFactoryBean getBean() {
		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("assessment-unit");
		return bean;
		
	}

}
