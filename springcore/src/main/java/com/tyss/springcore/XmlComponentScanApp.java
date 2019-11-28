package com.tyss.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tyss.springcore.di.Hello;
import com.tyss.springcore.di.Pet;

public class XmlComponentScanApp {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Hello hello = context.getBean(Hello.class);
		hello.setMsg("Raghava");
		System.out.println(hello.getMsg());
		
		Pet pet = context.getBean(Pet.class);
		pet.setName("siri");
		System.out.println(pet.getName());
		pet.getAnimal().makeSound();
		
	}

}
