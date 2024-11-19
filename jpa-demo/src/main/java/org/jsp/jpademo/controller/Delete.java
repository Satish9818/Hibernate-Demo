package org.jsp.jpademo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpademo.dto.Merchant;

public class Delete {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createNativeQuery("select * from merchant where name=?", Merchant.class);
		EntityTransaction transaction = manager.getTransaction();
		q.setParameter(1, "Bahubali");
		List<Merchant> ms = q.getResultList();
		for (Merchant m : ms) {
			System.out.println(m.getEmail());
		}

	}
}
