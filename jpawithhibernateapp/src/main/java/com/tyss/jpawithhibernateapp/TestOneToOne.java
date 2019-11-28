package com.tyss.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernateapp.onetoone.Person;
import com.tyss.jpawithhibernateapp.onetoone.VoterCard;

public class TestOneToOne {
	public static void main(String[] args) {
		VoterCard v = new VoterCard();
		v.setVid(10);
		v.setVname("Rama");
		
		Person p = new Person();
		p.setPid(1);
		p.setPname("Rama");
		p.setVoterCard(v);
		
		EntityTransaction entityTransaction = null;
		EntityManager entityManager = null;
		try {
		EntityManagerFactory  entityManagerFactory = 
				Persistence.createEntityManagerFactory("test");//only once
		 entityManager = entityManagerFactory.createEntityManager();
		 entityTransaction = entityManager.getTransaction();
		//whenever we r doing DML operations we need EntityTransaction
		entityTransaction.begin();
		VoterCard vCard = entityManager.find(VoterCard.class,10);
		System.out.println(vCard.getPerson().getPid());
		//entityManager.persist(p);
		System.out.println("Record saved");
		entityTransaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
			
		}
		entityManager.close();
	}//end of main()


}
