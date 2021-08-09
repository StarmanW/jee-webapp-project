package com.starmanw.api.repository;

import java.io.Serializable;

import jakarta.persistence.PersistenceException;
import jakarta.persistence.TransactionRequiredException;

/**
 * The interface of the base repository serves as the main repository that
 * contain several commonly used operation methods that interacts with the
 * entity manager.
 */
public interface BaseRepository<T extends Serializable> {
	/**
	 * Find the entity by the given primary key.
	 *
	 * @param primaryKey
	 *        The primary key for the entity.
	 * @return The managed entity of type T.
	 */
	T findById(Serializable primaryKey);

	/**
	 * Persist the new entity of type T.
	 *
	 * @param entity
	 *        The entity of type T.
	 */
	void persist(T entity);

	/**
	 * Merge the detached entity back to the persistence context.
	 *
	 * @param entity
	 *        The entity of type T.
	 * @return The managed entity of type T.
	 */
	T merge(T entity);

	/**
	 * Remove the entity from the persistence context.
	 *
	 * @param entity
	 *        The entity of type T.
	 */
	void remove(T entity);

	/**
	 * Synchronize the persistence context to the underlying database.
	 *
	 * @throws TransactionRequiredException
	 *         if there is no transaction or if the entity manager has not been
	 *         joined to the current transaction
	 * @throws PersistenceException
	 *         if the flush fails
	 */
	void flush();

	/**
	 * Clear the persistence context, causing all managed entities to become
	 * detached. Changes made to entities that have not been flushed to the database
	 * will not be persisted.
	 */
	void clear();
}
