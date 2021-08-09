package com.starmanw.impl.repository;

import com.starmanw.api.repository.StudentRepository;
import com.starmanw.entity.Student;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;

@ApplicationScoped
public class StudentRepositoryImpl extends BaseRepositoryImpl<Student> implements StudentRepository {
	/**
	 * Create the repository of with entity of type {@link Student}
	 */
	public StudentRepositoryImpl() {
		super(Student.class);
	}

	@Override
	public Student fetchByStudentId(String studentId) {
		try {
			return getEm().createNamedQuery(Student.BY_STUDENT_ID, Student.class)
					.setParameter(Student.STUDENT_ID, studentId).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
