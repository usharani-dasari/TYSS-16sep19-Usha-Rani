package com.tyss.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernateapp.dto.Product;

public class ReattachingDemo {
	
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
		System.out.println(entityManager.contains(productInfo));
		entityManager.detach(productInfo);
		System.out.println(entityManager.contains(productInfo));
		Product productInfo2 = entityManager.merge(productInfo);
		entityManager.clear();
		
		
		productInfo2.setPname("bangle");
		System.out.println("Update Record");
		entityTransaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			entityTransaction.rollback();
		}
		
		entityManager.close();
	}//end of main method

}//end of class
