package com.starmanw.api.repository;

import com.starmanw.entity.Student;

import jakarta.persistence.EntityManager;

/**
 * This repository interface contain methods that are specific to interacting
 * with the {@link EntityManager} for the {@link Student} entity type.
 */
public interface StudentRepository extends BaseRepository<Student> {
	/**
	 * Fetch a student by the student ID.
	 *
	 * @param studentId
	 *        The student ID.
	 * @return The {@link Student} entity.
	 */
	Student fetchByStudentId(String studentId);
}
