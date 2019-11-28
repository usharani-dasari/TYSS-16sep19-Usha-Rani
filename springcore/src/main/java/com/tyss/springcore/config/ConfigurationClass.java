package com.tyss.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.tyss.springcore.di.Cat;
import com.tyss.springcore.di.Dog;
import com.tyss.springcore.di.Hello;
import com.tyss.springcore.di.Pet;

@Configuration//this class starts behaving as beans.xml
public class ConfigurationClass {
	
	@Bean(name = "hello")//this method starts behaving as bean element,default scope is singleton
//	@Scope("prototype") if we keep scope as "prototype" destroy() method wont 
	//execute bcz for prototype scope,objects won't create in spring container
	public Hello getHello() {
		Hello hello = new Hello();
		hello.setMsg("I Love Python");
		return hello;
	}
	
	@Bean(name="dog")
	public Dog getDog() {
		return new Dog();
	}
	
	//Normal wiring
	
//	@Bean(name="pet")
//	public Pet getPet() {
//	    Pet pet = new Pet();
//		pet.setName("Bittu");
//		pet.setAnimal(getDog());//getDog() returns same object as it is spring 
//		return pet;
//	}
	
	@Bean(name="cat")
	public Cat getCat() {
		return new Cat();
				
		
	}
	
	//Auto wiring
	@Bean(name="pet")
	public Pet getPet() {
	    Pet pet = new Pet();
		pet.setName("Bittu");
		
		return pet;
	}

}
