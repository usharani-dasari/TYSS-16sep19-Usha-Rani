package com.testyantra.lambdaexpressions;

public class TestSquare {
	public static void main(String[] args) {
		SquareInterface sqI = x->x*x;
		System.out.println(sqI.square(4));
	}
	
}
