package com.tyss.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernateapp.dto.Product;

public class GetReference {
	public static void main(String[] args) {
		EntityTransaction entityTransaction = null;
		EntityManager entityManager = null;
		
		EntityManagerFactory  entityManagerFactory = 
				Persistence.createEntityManagerFactory("test");
		 entityManager = entityManagerFactory.createEntityManager();
		 Product productInfo = entityManager.getReference(Product.class, 105);
//		 Product productInfo = entityManager.find(Product.class, 105);
		 System.out.println(productInfo.getClass());

		 System.out.println(productInfo.getPid());
		 System.out.println(productInfo.getPname());
		 System.out.println(productInfo.getQuantity());

   
	     entityManager.close();

	}//end of main() method
}//end of class
