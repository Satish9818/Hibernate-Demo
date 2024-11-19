package org.jsp.jpademo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.jpademo.dto.Merchant;

public class UpdateMerchant {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter merchant id to update details");
		int id = s.nextInt();

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Merchant m = manager.find(Merchant.class, id);

		if (m != null) {
			System.out.println("Enter the Name,phone,email,gstNumber and password to update");
			m.setName(s.next());
			m.setPhone(s.nextLong());
			m.setEmail(s.next());
			m.setGst_number(s.next());
			m.setPassword(s.next());
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			transaction.commit();
		} else {
			System.err.println("Cannot Update Merchant as Entered id is invalid");
		}
	}
}
