package org.insurancecomp.config;

import org.insurancecomp.dao.CustomerDao;
import org.insurancecomp.dao.PolicyDao;
import org.insurancecomp.dao.PurchaseDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Configuration
public class SpringConfig {

	@Bean
	public EntityManagerFactory emf() {
		return Persistence.createEntityManagerFactory("mypersistence");
	}

	@Bean
	public CustomerDao customerDao() {
		return new CustomerDao(emf());
	}

	@Bean
	public PolicyDao policyDao() {

		return new PolicyDao(emf());
	}

	@Bean
	public PurchaseDao purchaseDao() {

		return new PurchaseDao(emf());
	}

}