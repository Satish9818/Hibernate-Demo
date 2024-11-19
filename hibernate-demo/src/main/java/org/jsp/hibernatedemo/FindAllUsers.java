package org.jsp.hibernatedemo;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FindAllUsers {

	public static void main(String[] args) {
		String hql = "select u from User u";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q = s.createQuery(hql);
		List<User> users = q.getResultList();

		for (User u : users) {
			System.out.println("User ID: " + u.getId());
			System.out.println("User Name: " + u.getName());
			System.out.println("User Email: " + u.getEmail());
			System.out.println("User Phone no: " + u.getPhone());
			System.out.println("----------------------------------");
		}

	}
}
