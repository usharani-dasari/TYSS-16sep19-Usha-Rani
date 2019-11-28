package com.tyss.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernateapp.dto.Product;

public class UpdateDemo {
	
public static void main(String[] args) {
	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;
	try {
	EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("test");
	entityManager = entityManagerFactory.createEntityManager();
	entityTransaction = entityManager.getTransaction();
	entityTransaction.begin();
	Product productInfo = entityManager.find(Product.class, 101);
	//there is no particular method in JPA.We have to find first,then we  have to update
	productInfo.setPname("Mobile");
	System.out.println("Updated Record");
	entityTransaction.commit();
}catch(Exception e) {
	e.printStackTrace();
	entityTransaction.rollback();
}
	entityManager.close();
}

}
