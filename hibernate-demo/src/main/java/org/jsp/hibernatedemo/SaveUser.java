package org.jsp.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class SaveUser {

	public static void main(String[] args) {
		User u=new User();
		u.setName("Satish");
		u.setPassword("Satish123");
		u.setEmail("satishpokz1@gmail.com");
		u.setPhone(7365949989L);
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
