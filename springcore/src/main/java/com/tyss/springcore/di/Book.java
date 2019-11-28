package com.tyss.springcore.di;

import org.springframework.beans.factory.annotation.Autowired;

public class Book {
	
	@Autowired
	private Author author;
	private String name;
	private double price;
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
