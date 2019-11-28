package com.tyss.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tyss.springcore.di.Author;
import com.tyss.springcore.di.Book;

@Configuration
public class BookConfiguration {
	
	@Bean(name="book")
	public Book getBook() {
		Book book = new Book();
		book.setName("java");
		book.setPrice(455.9);
		return book;
		
	}
	
	@Bean(name="author")
	public Author getAuthor() {
		Author author = new Author();
		author.setName("Ramraj");
		author.setPenName("BlackPen");
		return author;
	}

}
