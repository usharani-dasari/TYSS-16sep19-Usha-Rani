package com.tyss.jpawithhibernateapp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernateapp.onetomanyormanytoone.Pencil;
import com.tyss.jpawithhibernateapp.onetomanyormanytoone.PencilBox;

public class TestOneToMany {
	public static void main(String[] args) {
		
//		PencilBox peBox = new PencilBox();
//		peBox.setBid(1);
//		peBox.setBname("Apsara");
//		
//		Pencil p1 = new Pencil();
//		p1.setPid(11);
//		p1.setColor("red");
//		p1.setPencilBox(peBox);
//		
//		Pencil p2 = new Pencil();
//		p2.setPid(12);
//		p2.setColor("black");
//		p2.setPencilBox(peBox);
		
		Pencil p1 = new Pencil();
		p1.setPid(13);
		p1.setColor("red");
		
		
		Pencil p2 = new Pencil();
		p2.setPid(14);
		p2.setColor("black");
		
		List<Pencil> list = new ArrayList<Pencil>();
		list.add(p1);
		list.add(p2);
		
		PencilBox peBox2 = new PencilBox();
		peBox2.setPencil(list);
		
		
		
		
		EntityTransaction entityTransaction = null;
		EntityManager entityManager = null;
		try {
		EntityManagerFactory  entityManagerFactory = 
				Persistence.createEntityManagerFactory("test");//only once
		 entityManager = entityManagerFactory.createEntityManager();
		 entityTransaction = entityManager.getTransaction();
		//whenever we r doing DML operations we need EntityTransaction
		entityTransaction.begin();
		
//		entityManager.persist(p1);
//		entityManager.persist(p2);
		for(Pencil p:list) {
		System.out.println(p);
		}
		
		System.out.println("Record saved");
		entityTransaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
			
		}
		entityManager.close();
	}//end of main()


}
