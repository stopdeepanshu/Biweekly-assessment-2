package org.insurancecomp.dao;

import org.insurancecomp.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class CustomerDao {

	EntityManagerFactory emf;

	public CustomerDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void saveCustomer(Customer c) {

		EntityManager em = emf.createEntityManager();
		System.out.println("Saving started..");
		System.out.println("Yes, customer is savingg, and Entity Manager is coming:  " + em);
		try {
			em.getTransaction().begin();
			em.persist(c);
//			System.out.println("enddddddddddddddddddddddddd");
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public Customer login(String email, String password) {

		EntityManager em = emf.createEntityManager();

		TypedQuery<Customer> q = em.createQuery("from Customer where email=:e and password=:p", Customer.class);

		q.setParameter("e", email);
		q.setParameter("p", password);

		Customer c = null;

		try {
			c = q.getSingleResult();
		} catch (Exception e) {
			System.out.println("Invalid Credentials.");
		}

		return c;

	}

}