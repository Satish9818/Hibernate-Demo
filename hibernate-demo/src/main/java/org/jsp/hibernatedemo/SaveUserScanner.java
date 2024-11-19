package org.jsp.hibernatedemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveUserScanner {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		User u=new User();
		System.out.println("Enter The name");
		String name=sc.next();
		System.out.println("Enter the Password");
		String password=sc.next();
		System.out.println("Enter the Email");
		String email=sc.next();
		System.out.println("Enter the Phone Number");
		long phone=sc.nextLong();
		u.setName(name);
		u.setPassword(password);
		u.setEmail(email);
		u.setPhone(phone);
		
		System.out.println("ID before Saving user:"+u.getId());
		
		
		Configuration cfg=new Configuration().configure();
		SessionFactory factory= cfg.buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		
		int id=(Integer)s.save(u);
		t.commit();
		System.out.println("User Saved with id: "+id);
	}
}
