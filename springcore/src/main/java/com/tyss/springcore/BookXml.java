package com.tyss.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tyss.springcore.di.Book;

public class BookXml {
	
	public static void main(String[] args) {
		 ApplicationContext context = 
	    		   new ClassPathXmlApplicationContext("book.xml");
		 Book book = context.getBean(Book.class);
		 System.out.println(book.getName());
		 System.out.println(book.getPrice());
		 System.out.println(book.getAuthor().getName());
		 System.out.println(book.getAuthor().getPenName());
	}

}
