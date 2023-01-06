package com.jsp.student.courses;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestStudentCourses {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Omkar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student s1=new Student();
		s1.setName("Omkar");
		s1.setEmail("omkar@gmail.com");
		
		Courses c1=new Courses();
		c1.setCourse_name("SQL");
		c1.setDuration("3 months");
		
		Courses c2=new Courses();
		c2.setCourse_name("Java");
		c2.setDuration("3 months");
		
		Courses c3=new Courses();
		c3.setCourse_name("Advance Java");
		c3.setDuration("2 months");
		
		List<Courses> courses=new ArrayList();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		
		c1.setStudent(s1);
		c2.setStudent(s1);
		c3.setStudent(s1);
		
		
		s1.setCourses(courses);
		
		entityTransaction.begin();
		entityManager.persist(s1);
		entityManager.persist(c1);
		entityManager.persist(c2);
		entityManager.persist(c3);
		entityTransaction.commit();
		
		System.out.println("All Good");
	}

}
