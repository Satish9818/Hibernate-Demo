package org.jsp.hibernatedemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindUserByName {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Username to print the details");

		String name = sc.next();
		Session s = new Configuration().configure().buildSessionFactory().openSession();

		String qry = "select u from User u where u.name=?1";

		Query<User> q = s.createQuery(qry);

		q.setParameter(1, name);

		List<User> users = q.getResultList();

		if (users.size() > 0) {
			for (User u : users) {
				System.out.println("User ID :" + u.getId());
				System.out.println("User Name :" + u.getName());
				System.out.println("User Email :" + u.getEmail());
				System.out.println("User Phone :" + u.getPhone());
				System.out.println("==================================");
			}
		} else {
			System.err.println("No User found with the name :" + name);
		}

	}
}
