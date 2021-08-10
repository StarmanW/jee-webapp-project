package com.starmanw.common.dataloader;

import com.starmanw.common.StopWatch;
import com.starmanw.common.dataloader.data.CourseData;
import com.starmanw.common.dataloader.data.EnrollmentData;
import com.starmanw.common.dataloader.data.StudentData;

import jakarta.persistence.EntityManager;

public class DataloaderPostgreSqlDemo {
	public static void main(String[] args) {
		// Create entity manager
		final EntityManager em = DefaultEntityManagerFactory.getEm("JEE_DEMO_PU_NON_JTA", "local-postgresql", true);

		StopWatch stopWatch = new StopWatch();
		em.getTransaction().begin();

		// Load Student data
		StudentData.STUDENTS.stream().forEach(student -> {
			em.persist(student);
			System.out.println("Committed entity: " + student.toString());
		});

		// Load Course data
		CourseData.COURSES.stream().forEach(course -> {
			em.persist(course);
			System.out.println("Committed entity: " + course.toString());
		});

		// Load Enrollment data
		EnrollmentData.ENROLLMENTS.stream().forEach(enrollment -> {
			em.persist(enrollment);
			System.out.println("Committed entity: " + enrollment.toString());
		});
		em.getTransaction().commit();

		System.out.println(String.format("******************** Dataloader completed: %.4f ms ********************",
				stopWatch.elapsedTime()));

		// Cleanup resources
		em.close();
	}
}
