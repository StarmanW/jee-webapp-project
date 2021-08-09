package com.starmanw.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "STUDENT")
@NamedQueries(value = {
		@NamedQuery(name = Student.BY_STUDENT_ID, query = "SELECT s FROM Student s WHERE s.studentId=:studentId") })
public class Student implements Serializable {
	@Id
	@Column(name = "STUDENT_KEY")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_GENERATOR")
	@SequenceGenerator(name = "STUDENT_GENERATOR", sequenceName = "STUDENT_SEQ")
	private long studentKey;

	@Column(name = "STUDENT_ID", nullable = false, length = 10)
	private String studentId;

	@Column(name = "NAME", nullable = false, length = 255)
	private String name;

	@Column(name = "REGISTRATION_YEAR", nullable = false, length = 9)
	private String registrationYear;

	@OneToMany(mappedBy = "student")
	private List<Enrollment> enrollments;

	// Constants for JPA
	public static final String BY_STUDENT_ID = "fetchStudentEnrollment";
	public static final String STUDENT_RESULT_SET_MAPPING = "studentResultSetMapping";
	public static final String STUDENT_COURSE_RESULT_SET_MAPPING = "studentCourseResultSetMapping";

	public static final String STUDENT_KEY = "studentKey";
	public static final String STUDENT_ID = "studentId";
	public static final String NAME = "name";
	public static final String REGISTRATION_YEAR = "registrationYear";

	/** Empty Parameter Constructor */
	public Student() {
	}

	/** Parameterized Constructor */
	public Student(String studentId, String name, String registrationYear) {
		this.studentId = studentId;
		this.name = name;
		this.registrationYear = registrationYear;
	}

	/** Getter for studentId */
	public String getStudentId() {
		return studentId;
	}

	/** Setter for studentId */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	/** Getter for name */
	public String getName() {
		return name;
	}

	/** Setter for name */
	public void setName(String name) {
		this.name = name;
	}

	/** Getter for registrationYear */
	public String getRegistrationYear() {
		return registrationYear;
	}

	/** Setter for registrationYear */
	public void setRegistrationYear(String registrationYear) {
		this.registrationYear = registrationYear;
	}

	/** Getter for enrollments */
	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	/** Setter for enrollments */
	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	@Override
	public String toString() {
		return "Student [studentKey=" + studentKey + ", studentId=" + studentId + ", name=" + name
				+ ", registrationYear=" + registrationYear + ", enrollments=" + enrollments + "]";
	}
}
