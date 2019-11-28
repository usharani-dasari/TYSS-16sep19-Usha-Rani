package com.tyss.springcore.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("pet")
public class Pet {
	public Pet() {
		
	}
	
	public Pet(String name,Animal animal) {
		this.name = name;
		this.animal = animal;
	}
	private String name;
	@Autowired//this Annotation is very very important
	//this annotation can be used by the Constructor 
	//if and only if if all the constructor arguements are defined as bean.
	//but rarly we use for constructor
	
	@Qualifier("cat")//It just qualifies cat.It is like "byName" 
	private Animal animal;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}


}
