package com.starmanw.common.util;

import static org.eclipse.persistence.config.PersistenceUnitProperties.DDL_DATABASE_GENERATION;
import static org.eclipse.persistence.config.PersistenceUnitProperties.DDL_GENERATION;
import static org.eclipse.persistence.config.PersistenceUnitProperties.DDL_GENERATION_MODE;
import static org.eclipse.persistence.config.PersistenceUnitProperties.DROP_AND_CREATE;
import static org.eclipse.persistence.config.PersistenceUnitProperties.JDBC_DRIVER;
import static org.eclipse.persistence.config.PersistenceUnitProperties.JDBC_PASSWORD;
import static org.eclipse.persistence.config.PersistenceUnitProperties.JDBC_URL;
import static org.eclipse.persistence.config.PersistenceUnitProperties.JDBC_USER;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DefaultEntityManagerFactory {
	/**
	 * Get entity manager instance
	 */
	public static EntityManager getEm(String persistenceUnit, String propertyFileName, boolean dropAndCreate) {
		EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory(persistenceUnit,
				getEmProperty(propertyFileName, dropAndCreate));
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		return em;
	}

	/**
	 * Get entity manager property
	 */
	private static Map<String, String> getEmProperty(String propertyFileName, boolean dropAndCreate) {
		Map<String, String> prop = new HashMap<>();
		Properties properties = readProperties(propertyFileName);

		prop.put(JDBC_DRIVER, properties.getProperty(JDBC_DRIVER));
		prop.put(JDBC_URL, properties.getProperty(JDBC_URL));
		prop.put(JDBC_USER, properties.getProperty(JDBC_USER));
		prop.put(JDBC_PASSWORD, properties.getProperty(JDBC_PASSWORD));

		if (dropAndCreate) {
			prop.put(DDL_GENERATION, DROP_AND_CREATE);
			prop.put(DDL_GENERATION_MODE, DDL_DATABASE_GENERATION);
		}

		return prop;
	}

	/**
	 * Read specific database properties
	 */
	private static Properties readProperties(String filename) {
		try {
			InputStream input = DefaultEntityManagerFactory.class.getClassLoader()
					.getResourceAsStream(filename + ".properties");
			Properties prop = new Properties();

			// Input null check
			if (input == null) {
				System.out.println(String.format("Sorry, unable to find %s.properties", filename));
				return null;
			}

			// Load properties file
			prop.load(input);
			return prop;
		} catch (Exception ex) {
			System.out.println(String.format("Error loading properties: %s", ex.getMessage()));
			ex.printStackTrace();
		}
		return null;
	}
}
