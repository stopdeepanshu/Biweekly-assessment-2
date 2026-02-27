package org.insurancecomp.dao;

import org.insurancecomp.entity.Purchase;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class PurchaseDao {

	EntityManagerFactory emf;

	public PurchaseDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void buyPolicy(Purchase p) {

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(p);

		em.getTransaction().commit();

	}

}