package com.tyss.jpawithhibernateapp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernateapp.manytomany.Course;
import com.tyss.jpawithhibernateapp.manytomany.Student;

public class TestManyToMany {
	public static void main(String[] args) {
		
		Course course1 = new Course();
		course1.setCid(10);
		course1.setCname("java");
		
		Course course2 = new Course();
		course2.setCid(20);
		course2.setCname("sql");
		
		List<Course> list = new ArrayList<Course>();
		list.add(course1);
		list.add(course2);
		
		
		Student s = new Student();
		s.setSid(1);
		s.setSname("Usha");
		s.setCourse(list);
		
		
		
		EntityTransaction entityTransaction = null;
		EntityManager entityManager = null;
		try {
		EntityManagerFactory  entityManagerFactory = 
				Persistence.createEntityManagerFactory("test");
		 entityManager = entityManagerFactory.createEntityManager();
		 entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(s);
		
		
		System.out.println("Record saved");
		entityTransaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
			
		}
		entityManager.close();
	}

}
