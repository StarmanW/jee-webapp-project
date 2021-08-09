package com.starmanw.common.util.data;

import static com.starmanw.common.util.data.CourseData.COURSES;
import static com.starmanw.common.util.data.StudentData.STUDENTS;

import java.util.ArrayList;
import java.util.List;
import com.starmanw.entity.Enrollment;

public class EnrollmentData {
	public static final List<Enrollment> ENROLLMENTS = new ArrayList<Enrollment>() {
		{
			add(new Enrollment(STUDENTS.get(0), COURSES.get(1)));
			add(new Enrollment(STUDENTS.get(0), COURSES.get(3)));
			add(new Enrollment(STUDENTS.get(0), COURSES.get(0)));
			add(new Enrollment(STUDENTS.get(1), COURSES.get(0)));
			add(new Enrollment(STUDENTS.get(1), COURSES.get(1)));
			add(new Enrollment(STUDENTS.get(2), COURSES.get(2)));
			add(new Enrollment(STUDENTS.get(2), COURSES.get(3)));
			add(new Enrollment(STUDENTS.get(2), COURSES.get(0)));
			add(new Enrollment(STUDENTS.get(3), COURSES.get(2)));
			add(new Enrollment(STUDENTS.get(4), COURSES.get(2)));
			add(new Enrollment(STUDENTS.get(4), COURSES.get(1)));
			add(new Enrollment(STUDENTS.get(4), COURSES.get(3)));
		}
	};
}
