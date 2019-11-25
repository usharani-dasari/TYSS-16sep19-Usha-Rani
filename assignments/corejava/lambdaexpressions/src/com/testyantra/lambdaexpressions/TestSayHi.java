package com.testyantra.lambdaexpressions;

public class TestSayHi {
	
	public static void main(String[] args) {
		SayHiInterface sHI = ()->System.out.println("hi");
		sHI.sayHi();
	}

}
