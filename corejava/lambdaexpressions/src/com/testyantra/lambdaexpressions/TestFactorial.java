package com.testyantra.lambdaexpressions;

public class TestFactorial {
	public static void main(String[] args) {
		FactorialInterface fI = (a)->{
			int fact = 1;
			for(int i=2;i<=a;i++) {
				fact *=i;
			}
			return fact;
		};
		
		System.out.println(fI.fact(4));
		
		
	}
}
