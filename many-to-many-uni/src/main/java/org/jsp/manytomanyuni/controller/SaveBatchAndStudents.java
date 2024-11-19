package org.jsp.manytomanyuni.controller;

import org.jsp.manytomanyuni.dto.Batch;
import org.jsp.manytomanyuni.dto.Student;

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
		
		Student s1=new Student();
		
	}
}
