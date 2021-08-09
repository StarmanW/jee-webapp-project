package com.starmanw.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.starmanw.api.repository.StudentRepository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@RequestScoped
@Named(value = "w001")
public class WelcomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(WelcomeController.class);

	@Inject
	StudentRepository studentRepository;

	private String studentName;

	public void getStudentNameByKey() {
		this.studentName = studentRepository.findById(1l).getName();
	}

	public void getStudentNameById() {
		LOGGER.info("REQUESTED FOR STUDENT ENTITY");
		this.studentName = studentRepository.fetchByStudentId("18WMR12001").getName();
	}

	public String getAction() {
		return "/com/test/";
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
