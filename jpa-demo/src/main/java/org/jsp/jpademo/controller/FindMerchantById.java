package org.jsp.jpademo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.jpademo.dto.Merchant;

public class FindMerchantById {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter merchant id to display details");
		int id = s.nextInt();

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Merchant m = manager.find(Merchant.class, id);

		if (m != null) {
			System.out.println("Merchant id: " + m.getId());
			System.out.println("Merchant Name: " + m.getName());
			System.out.println("Merchant Phoneno: " + m.getPhone());
			System.out.println("Merchant Email Id: " + m.getEmail());
			System.out.println("Merchant Gst Number: " + m.getGst_number());
		} else {
			System.err.println("Invalid Merchant ID");
		}
	}
}
