package com.tyss.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernateapp.dto.Product;

public class InsertDemo {
	public static void main(String[] args) {
		Product productInfo = new Product();
		productInfo.setPid(103);
		productInfo.setPname("mirror");
		productInfo.setQuantity(10);
		EntityTransaction entityTransaction = null;
		EntityManager entityManager = null;
		try {
		EntityManagerFactory  entityManagerFactory = 
				Persistence.createEntityManagerFactory("test");//only once
		 entityManager = entityManagerFactory.createEntityManager();
		 entityTransaction = entityManager.getTransaction();
		//whenever we r doing DML operations we need EntityTransaction
		entityTransaction.begin();
		entityManager.persist(productInfo);
		System.out.println("Record saved");
		entityTransaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
			
		}
		entityManager.close();
	}//end of main()

}//end of the class
