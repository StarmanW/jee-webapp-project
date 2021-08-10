package com.starmanw.demo.primefaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.starmanw.api.repository.StudentRepository;
import com.starmanw.entity.Student;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@LocalBean
@Stateless
public class PrimefacesDemoScreenFacade {
	private static final Logger LOGGER = LoggerFactory.getLogger(PrimefacesDemoScreenFacade.class);

	@Inject
	StudentRepository studentRepository;

	public void getStudentNameById(PrimefacesDemoScreenModel model) {
		LOGGER.info("REQUESTED FOR STUDENT ENTITY");
		Student student = studentRepository.fetchByStudentId(model.getStudentId());

		if (student != null) {
			model.setStudentName(student.getName());
		}
	}
}
