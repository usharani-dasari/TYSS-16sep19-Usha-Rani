package com.tyss.jpawithhibernateapp.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpawithhibernateapp.dto.Product;

public class ReadDemo {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		String jpql = "from Product";
		String jpql = "select pname from Product";
		Query query = entityManager.createQuery(jpql);
		List<String> list = query.getResultList();
		
		  for(String s:list) { 
			 
		  System.out.println("Name--"+s);
		  }
		 
		entityManager.close();
		
	}

}
