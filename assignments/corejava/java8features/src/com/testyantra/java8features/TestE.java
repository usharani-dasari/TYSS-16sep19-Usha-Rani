package com.testyantra.java8features;

import java.util.function.Supplier;

public class TestE {
	public static void main(String[] args) {
		
		Supplier<Student> s = () ->new Student(2,"ajay",65.6);
		Student s1 = s.get();
		System.out.println("Id is "+s1.id);
		System.out.println("Name is "+s1.name);
		System.out.println("Percentage is "+s1.percentage);
		
		Supplier<Integer> i = () ->20;
		int val = i.get();
		System.out.println("value is "+val);
		
		Supplier<String> sp = () -> "Good EVening";
		String v = sp.get();
		System.out.println("value "+v);
		
	}

}
