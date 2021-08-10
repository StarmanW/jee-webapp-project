package com.starmanw.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.starmanw.api.StarmanWConstants;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

/**
 * Interceptor for page links
 */
@Interceptor
public class PageLinksInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(PageLinksInterceptor.class);

	/**
	 * Concatenate the base URL for all page links
	 */
	@AroundInvoke
	public Object concatenateBaseUrl(InvocationContext ctx) throws Exception {
		try {
			return StarmanWConstants.BASE_URL + ctx.proceed();
		} catch (Exception e) {
			LOGGER.warn("Error while concatenating the base URL for page links.");
			return null;
		}
	}
}
