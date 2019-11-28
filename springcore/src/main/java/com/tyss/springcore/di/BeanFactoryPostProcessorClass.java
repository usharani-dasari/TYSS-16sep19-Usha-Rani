package com.tyss.springcore.di;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BeanFactoryPostProcessorClass implements BeanFactoryPostProcessor {
	//only once before intialization phase BeanFactoryPostProcessor executes
	//it is one time fore all the bean
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("BeanFactoryPostProcessor Executing");
		
	}

}
