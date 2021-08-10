package com.starmanw.demo.primefaces;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@RequestScoped
@Named("p01")
public class PrimefacesDemoController {
	@Inject
	PrimefacesDemoScreenFacade screenFacade;

	@Inject
	PrimefacesDemoScreenModel model;

	public void getStudent() {
		model.setStudentId("18WMR12001");
		screenFacade.getStudentNameById(model);
	}

	public String getAction() {
		return "/com/test/";
	}

	/**
	 * Get the screen model
	 */
	public PrimefacesDemoScreenModel getModel() {
		return model;
	}
}
