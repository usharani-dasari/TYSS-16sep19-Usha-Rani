package com.tyss.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tyss.springcore.config.BookConfiguration;
import com.tyss.springcore.di.Author;
import com.tyss.springcore.di.Book;

public class BookAnnotation {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(BookConfiguration.class);
		
		Book book = context.getBean(Book.class);
		System.out.println(book.getName());
		System.out.println(book.getPrice());
		System.out.println(book.getAuthor().getName());
		System.out.println(book.getAuthor().getPenName());
		
		Author author = context.getBean(Author.class);
		System.out.println(author.getName());
		System.out.println(author.getPenName());
	}

}
