package com.testyantra.streams.list;

import java.util.ArrayList;


public class TestS {
	public static void main(String[] args) {
		
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student(5,"vikram",56.7));
		al.add(new Student(7,"rama",78.9));
		al.add(new Student(6,"hasa",90.9));
		al.add(new Student(1,"krishna",35.7));
		al.add(new Student(9, "kaveesh",23));
		
		Helper h = new Helper();
//		h.displayAllStudent(al);
		h.displayFailedStudents(al);
		h.topperOfClass(al);
		
	}

}
