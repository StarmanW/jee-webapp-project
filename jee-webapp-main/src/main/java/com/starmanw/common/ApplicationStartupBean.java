package com.starmanw.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

/**
 * https://stackoverflow.com/a/18274618/6691218<br>
 * Application start-up initialization and pre-destroy
 */
@Startup
@Singleton
public class ApplicationStartupBean {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStartupBean.class);

	@PostConstruct
	public void applicationStartup() {
		LOGGER.info("APPLICATION STARTUP FIRED");
	}

	@PreDestroy
	public void applicationPreShutDown() {
		LOGGER.info("APPLICATION SHUTTING DOWN...");
	}
}
