package com.tyss.jpawithhibernateapp.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicInsert {
	public static void main(String[] args) {
		
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;

		try {
			EntityManagerFactory entityManagerFactory = 
					Persistence.createEntityManagerFactory("test");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			String jpql = "insert into Product(pid,pname,quantity) values(:id,:name,:quantity)";
			Query query= entityManager.createNativeQuery(jpql);
		
			query.setParameter("id", 101);
			query.setParameter("name", "Bakery");
			query.setParameter("quantity", 12);
			int result = query.executeUpdate();
			System.out.println(result);
			entityTransaction.commit();

		}catch(Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();

		}finally {
			entityManager.close();
		}
	}

}
