package com.starmanw.impl.repository;

import java.io.Serializable;

import com.starmanw.api.repository.BaseRepository;
import com.starmanw.api.repository.JeeDemoDatabase;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

/**
 * This abstract class implements the base operation method defined in
 * {@link BaseRepository}
 */
public abstract class BaseRepositoryImpl<T extends Serializable> implements BaseRepository<T> {
	@Inject
	@JeeDemoDatabase
	private EntityManager em;

	private final Class<T> entityClazz;

	/**
	 * Get the entity manager for sub-classes
	 */
	protected EntityManager getEm() {
		return em;
	}

	/**
	 * Create the {@link BaseRepositoryImpl} with empty parameter
	 */
	BaseRepositoryImpl() {
		this.entityClazz = null;
	}

	/**
	 * Create the {@link BaseRepositoryImpl} with the given entity type
	 */
	protected BaseRepositoryImpl(Class<T> entityClazz) {
		this.entityClazz = entityClazz;
	}

	@Override
	public T findById(Serializable primaryKey) {
		return em.find(entityClazz, primaryKey);
	}

	@Override
	public void persist(T entity) {
		em.persist(entity);
	}

	@Override
	public T merge(T entity) {
		return em.merge(entity);
	}

	@Override
	public void remove(T entity) {
		em.remove(entity);
	}

	@Override
	public void flush() {
		em.flush();
	}

	@Override
	public void clear() {
		em.clear();
	}
}
