package org.jsp.hibernatedemo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VerifyByPhoneAndPassword {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Phone Number and Password to verify the User");
		long phone = sc.nextLong();
		String password = sc.next();

		String qry = "select u from User u where u.phone=?1 and u.password=?2";

		Session s = new Configuration().configure().buildSessionFactory().openSession();

		Query<User> q = s.createQuery(qry);

		q.setParameter(1, phone);
		q.setParameter(2, password);

		try {
			User u = q.getSingleResult();
			System.out.println("User ID :" + u.getId());
			System.out.println("User ID :" + u.getName());
			System.out.println("User ID :" + u.getEmail());
			System.out.println("User ID :" + u.getPhone());
			System.out.println("==================================");
		} catch (NoResultException e) {
			System.err.println("Invalid Phone number or Password");
		}
	}
}
