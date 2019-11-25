package com.testyantra.studentapp.qspiders;

//import com.testyantra.studentapp.jspiders.Angular;
//import com.testyantra.studentapp.jspiders.React;
import com.testyantra.studentapp.jspiders.*;

public class TestA {
	
	public static void main(String[] args) {
		QTP q = new QTP();
		q.teachQtp();
		
		
		Selenium s = new Selenium();
		s.teachSelenium();
		
//		com.testyantra.studentapp.jspiders.Angular a = 
//				new com.testyantra.studentapp.jspiders.Angular();
		Angular a = new Angular();
		a.teachAngular();
		
		React r = new React();
		
	}

}
