package com.tyss.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernateapp.dto.Product;

public class ReadDemo {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Product productDetails = entityManager.find(Product.class,101);
		System.out.println("ID--"+productDetails.getPid());
		System.out.println("NAME--"+productDetails.getPname());
		System.out.println("QUANTITY--"+productDetails.getQuantity());
		
	}//end of main method

}//end of class
