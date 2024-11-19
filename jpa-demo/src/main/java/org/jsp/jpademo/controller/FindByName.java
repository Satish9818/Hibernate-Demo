package org.jsp.jpademo.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpademo.dto.Merchant;

public class FindByName {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createNamedQuery("findByName");
		System.out.println("Enter the merchant name to display details");
		String name = s.next();
		q.setParameter(1, name);
		List<Merchant> merchants = q.getResultList();
		if (merchants.size() > 0) {
			for (Merchant m : merchants) {
				System.out.println("Merchant Id: " + m.getId());
				System.out.println("Merchant Name: " + m.getName());
				System.out.println("Phone Number: " + m.getPhone());
				System.out.println("Email ID: " + m.getEmail());
				System.out.println("GST Number: " + m.getGst_number());
			}
		} else {
			System.err.println("No merchant with entered name");
		}
	}

}
