package com.jsp.hospital.branch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestHospitalBranch {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Omkar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Hospital h1=new Hospital();
		h1.setName("Reliance Hospital");
		
		Branch b1=new Branch();
		b1.setName("Branch1");
		b1.setAddress("Vashi");
		b1.setHospital(h1);
		
		Branch b2=new Branch();
		b2.setName("Branch2");
		b2.setAddress("Thane");
		b2.setHospital(h1);
		
		Branch b3=new Branch();
		b3.setName("Branch3");
		b3.setAddress("Koparkhairane");
		b3.setHospital(h1);
		
		List<Branch> branch=new ArrayList();
		branch.add(b1);
		branch.add(b2);
		branch.add(b3);
		
		h1.setBranch(branch);
		
		entityTransaction.begin();
		entityManager.persist(h1);
		entityTransaction.commit();
		System.out.println("All Good");
		
		
		
	}

}
