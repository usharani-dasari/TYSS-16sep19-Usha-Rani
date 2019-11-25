package com.testyantra.java8features;

import java.util.function.Predicate;

public class TestA {
	public static void main(String[] args) {
		
		Predicate<Integer> p = i ->{
			if(i%2==0) {
				return true;
			}else {
				return false;
			}
		};
		boolean oddEven = p.test(10);
		System.out.println("oddEven "+oddEven);
	}

}
