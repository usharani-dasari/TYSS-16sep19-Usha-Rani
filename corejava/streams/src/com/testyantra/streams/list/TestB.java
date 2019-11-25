package com.testyantra.streams.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestB {
	public static void main(String[] args) {
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(20);
		al.add(23);
		al.add(56);
		al.add(12);
		al.add(24);
		al.add(90);
		
		List<Integer> l = al.stream().filter(i -> i%3==0).collect(Collectors.toList());
		
		System.out.println(l);
		
		for(Integer i:l) {
			System.out.println(i);
		}
	}

}
