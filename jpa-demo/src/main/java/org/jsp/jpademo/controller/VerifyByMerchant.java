package org.jsp.jpademo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpademo.dto.Merchant;

public class VerifyByMerchant {
	public static void main(String[] args) {
		System.out.println("1.Verify Merchant by Phone and Passoword");
		System.out.println("2.Verify Merchant by Email and Password");
		System.out.println("3.Verify Email by ID and Password");
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = null;

		switch (choice) {
		case 1: {
			q = manager.createNamedQuery("verifyByPhone");
			System.out.println("Enter the Phone and Password");
			q.setParameter(1, s.nextLong());
			q.setParameter(2, s.next());
			break;
		}
		case 2: {
			q = manager.createNamedQuery("verifyByEmail");
			System.out.println("Enter the Email and Password");
			q.setParameter(1, s.next());
			q.setParameter(2, s.next());
			break;
		}
		case 3: {
			q = manager.createNamedQuery("verifyById");
			System.out.println("Enter the ID and Password");
			q.setParameter(1, s.nextInt());
			q.setParameter(2, s.next());
			break;
		}
		}
		try {
			Merchant m = (Merchant) q.getSingleResult();
			System.out.println("Verification Successful");
			System.out.println("Merchant ID: " + m.getId());
			System.out.println("Merchant Name: " + m.getName());
			System.out.println("Phone Number: " + m.getPhone());
			System.out.println("Email ID: " + m.getEmail());
		} catch (NoResultException e) {
			System.err.println("INVALID PHONE OR EMAIL OR ID OR PASSWORD");
		}
	}
}
