package com.testyantra.lambdaexpressions;

public class TestGreet {
	
	public static void main(String[] args) {
		GreetInterface gi = (message)->{
			System.out.println("Hi");
			System.out.println(message);
		};
		
		gi.greet("usha");
		
	}

}
