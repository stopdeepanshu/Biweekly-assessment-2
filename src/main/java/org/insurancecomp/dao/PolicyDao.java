package org.insurancecomp.dao;

import java.util.List;
import org.insurancecomp.entity.Policy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class PolicyDao {

	EntityManagerFactory emf;

	public PolicyDao(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
//	public List<Policy> getPolicies(){
//
//	I want a project on this in which user and admin can  login seprately, and admin 
	
	
//		 EntityManager em = emf.createEntityManager();
//
//		 TypedQuery<Policy> q =
//		 em.createQuery("from Policy", Policy.class);
//
//		 return q.getResultList();
//
//		}

	public void addPolicy(Policy p) {

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(p);

		em.getTransaction().commit();

	}

	public List<Policy> getPolicies() {

		EntityManager em = emf.createEntityManager();

		TypedQuery<Policy> q = em.createQuery("from Policy", Policy.class);

		return q.getResultList();
	}

}
