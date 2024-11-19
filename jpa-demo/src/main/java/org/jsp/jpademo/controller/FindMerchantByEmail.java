package org.jsp.jpademo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpademo.dto.Merchant;

public class FindMerchantByEmail {
	public static void main(String[] args) {

		String jpql = "select m from Merchant m where m.email=?1";
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Merchant Email to print details");

		String email = s.next();

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(jpql);
		q.setParameter(1, email);
		try {
			Merchant m = (Merchant) q.getSingleResult();
			System.out.println("Merchant ID: " + m.getId());
			System.out.println("Merchant Name: " + m.getName());
			System.out.println("Phone Number: " + m.getPhone());
			System.out.println("Email ID: " + m.getEmail());
			System.out.println("GST Number: " + m.getGst_number());
		} catch (NoResultException e) {
			System.err.println("Invalid Email ID");
		}
	}
}
