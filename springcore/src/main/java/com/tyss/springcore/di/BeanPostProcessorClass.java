package com.tyss.springcore.di;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorClass implements BeanPostProcessor {
	//these r the 2 default methods in BeanPostProcessor interface
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean before Initialization: "+beanName);
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean after initialization: "+beanName);
		return bean;
	}

}
