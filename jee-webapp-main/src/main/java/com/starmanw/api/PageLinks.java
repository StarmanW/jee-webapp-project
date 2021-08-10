package com.starmanw.api;

import com.starmanw.common.PageLinksInterceptor;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.interceptor.Interceptors;

/**
 * Page links for the application
 */
@Named("pageLinks")
@ApplicationScoped
@Interceptors(PageLinksInterceptor.class)
public class PageLinks {
	public String getPrimefacesDemoPage() {
		return "/com/starmanw/demo/primefaces/BasicTagsDemo.xhtml";
	}
}
