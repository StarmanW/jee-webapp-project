package com.starmanw.common.dataloader;

import com.starmanw.common.dataloader.data.CourseData;
import com.starmanw.common.dataloader.data.EnrollmentData;
import com.starmanw.common.dataloader.data.StudentData;

import jakarta.persistence.EntityManager;

public class DataloaderPostgreSqlDemo {
	public static void main(String[] args) {
		// Create entity manager
		final EntityManager em = DefaultEntityManagerFactory.getEm("JEE_DEMO_PU_NON_JTA", "local-postgresql", true);

		// Load Student data
		StudentData.STUDENTS.stream().forEach(student -> {
			em.getTransaction().begin();
			em.persist(student);
			em.getTransaction().commit();
			System.out.println("Committed entity: " + student.toString());
		});

		// Load Course data
		CourseData.COURSES.stream().forEach(course -> {
			em.getTransaction().begin();
			em.persist(course);
			em.getTransaction().commit();
			System.out.println("Committed entity: " + course.toString());
		});

		// Load Enrollment data
		EnrollmentData.ENROLLMENTS.stream().forEach(enrollment -> {
			em.getTransaction().begin();
			em.persist(enrollment);
			em.getTransaction().commit();
			System.out.println("Committed entity: " + enrollment.toString());
		});

		// Cleanup resources
		em.close();
	}
}
