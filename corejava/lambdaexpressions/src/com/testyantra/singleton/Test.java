package com.testyantra.singleton;

public class Test {
	public static void main(String[] args) {
		
		MySingleton ms = MySingleton.getDbConnection();
		ms.s = "hello";
		System.out.println("hashcode of ms "+ms.hashCode());
		MySingleton mx = MySingleton.getDbConnection();
		mx.s = "Hi";
		System.out.println("hashcode of mx "+mx.hashCode());
		
		System.out.println(ms.s);
		System.out.println(mx.s);
	}

}
