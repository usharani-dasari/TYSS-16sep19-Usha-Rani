package com.testyantra.java8features;

import java.util.function.Function;

public class TestC {
	public static void main(String[] args) {
		
		Function<Integer,Integer> f = i->i*i;
		int i = f.apply(4);
		System.out.println("square of 4 is "+i);
		
		int result = f.apply(5);
		System.out.println("squareof 5 is "+result);
	}
	
	

}
