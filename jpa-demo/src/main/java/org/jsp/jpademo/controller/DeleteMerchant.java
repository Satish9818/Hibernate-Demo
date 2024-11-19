package org.jsp.jpademo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.jpademo.dto.Merchant;

public class DeleteMerchant {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the merchant id to delete");
		int id=s.nextInt();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Merchant m = manager.find(Merchant.class,id);

		if (m != null) {
			manager.remove(m);
			transaction.begin();
			transaction.commit();
		} else {
			System.err.println("Invalid ID");
		}

	}
}
