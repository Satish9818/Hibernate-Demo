package org.jsp.hibernatedemo;

import java.util.Scanner;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class LoadDemo {

	public static void main(String[] args) {
		
	
	Session s=new Configuration().configure().buildSessionFactory().openSession();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the user id to print the details");
	
	int id=sc.nextInt();
	User u=s.load(User.class,id);
	
	try {
		System.out.println("User id :"+u.getId());
		System.out.println("User Name :"+u.getName());
		System.out.println("Email id "+u.getEmail());
		System.out.println("Phone number :"+u.getPhone());
	}catch(ObjectNotFoundException e)
	{
		System.err.println("You have Entered an Invalid ID");
	}
}
}