package org.jsp.jpademo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.jpademo.dto.Merchant;

public class UpdateMerchant2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter merchant id to update details");
		int id = s.nextInt();
		
		Merchant m = new Merchant();

		System.out.println("Enter the Name,phone,email,gstNumber and password to update");
		m.setName(s.next());
		m.setPhone(s.nextLong());
		m.setEmail(s.next());
		m.setGst_number(s.next());
		m.setPassword(s.next());
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		m = manager.merge(m);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();

		System.out.println("merchant Updated with id : " + m.getId());

	}
}
