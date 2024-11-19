package org.jsp.jpademo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.jpademo.dto.Merchant;

public class SaveMerchant {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Name,Phone,Email,gst_number, and password");

		Merchant m = new Merchant();

		m.setName(s.next());
		m.setPhone(s.nextLong());
		m.setGst_number(s.next());
		m.setEmail(s.next());
		m.setPassword(s.next());

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		manager.persist(m);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
		System.out.println("Merchant registered with ID: " + m.getId());

	}
}
