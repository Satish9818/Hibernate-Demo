package org.jsp.manytomanybi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.manytomanybi.dto.Batch;
import org.jsp.manytomanybi.dto.Student;

public class SaveBatchAndStudents {

	public static void main(String[] args) {
		Batch b1 = new Batch();
		b1.setBatch_code("JBT-JFRADD-A4");
		b1.setSubject("ADJAVA");
		b1.setTrainer("Gururaja");

		Batch b2 = new Batch();
		b2.setBatch_code("JBT-JFRHID-A2");
		b2.setSubject("Hibernate");
		b2.setTrainer("Satish");

		Batch b3 = new Batch();
		b3.setBatch_code("JBT-JFRRJS-M3");
		b3.setSubject("React");
		b3.setTrainer("Prajwal");

		Student s1 = new Student();
		s1.setName("Messi");
		s1.setPerc(90);
		s1.setYop(2000);

		Student s2 = new Student();
		s2.setName("Ronaldo");
		s2.setPerc(95);
		s2.setYop(1999);

		Student s3 = new Student();
		s3.setName("Neymar");
		s3.setPerc(80);
		s3.setYop(2005);

		List<Student> forB1 = new ArrayList<Student>(Arrays.asList(s1, s2, s3));
		List<Student> forB2 = new ArrayList<Student>(Arrays.asList(s1, s3));
		List<Student> forB3 = new ArrayList<Student>(Arrays.asList(s1, s2, s3));

		b1.setStudents(forB1);
		b1.setStudents(forB2);
		b1.setStudents(forB3);

		List<Batch> forS1 = new ArrayList<Batch>(Arrays.asList(b1, b2, b3));
		List<Batch> forS2 = new ArrayList<Batch>(Arrays.asList(b1, b3));
		List<Batch> forS3 = new ArrayList<Batch>(Arrays.asList(b1, b2, b3));

		s1.setBatches(forS1);
		s1.setBatches(forS2);
		s1.setBatches(forS3);

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);

		transaction.begin();
		transaction.commit();

	}
}
