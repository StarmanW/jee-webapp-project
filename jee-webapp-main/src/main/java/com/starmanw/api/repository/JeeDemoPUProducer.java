package com.starmanw.api.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * See
 * https://stackoverflow.com/questions/19431423/getting-a-reference-to-entitymanager-in-java-ee-applications-using-cdi
 * for more information
 */
@Dependent
public class JeeDemoPUProducer {
	@PersistenceContext(unitName = "JEE_DEMO_PU")
	private EntityManager em;

	@Produces
	@RequestScoped
	@JeeDemoDatabase
	public EntityManager createEntityManager() {
		return em;
	}
}
