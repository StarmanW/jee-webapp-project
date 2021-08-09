package com.starmanw.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENROLLMENT")
public class Enrollment implements Serializable {
	@Id
	@Column(name = "ENROLLMENT_KEY")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENROLLMENT_GENERATOR")
	@SequenceGenerator(name = "ENROLLMENT_GENERATOR", sequenceName = "ENROLLMENT_SEQ")
	private long enrollmentKey;

	@ManyToOne
	@JoinColumn(name = "STUDENT_KEY")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "COURSE_KEY")
	private Course course;

	public Enrollment() {
	}

	public Enrollment(Student student, Course course) {
		this.student = student;
		this.course = course;
	}

	/** Getter for enrollmentKey */
	public long getEnrollmentKey() {
		return enrollmentKey;
	}

	/** Setter for enrollmentKey */
	public void setEnrollmentKey(long enrollmentKey) {
		this.enrollmentKey = enrollmentKey;
	}

	/** Getter for student */
	public Student getStudent() {
		return student;
	}

	/** Setter for student */
	public void setStudent(Student student) {
		this.student = student;
	}

	/** Getter for course */
	public Course getCourse() {
		return course;
	}

	/** Setter for course */
	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Enrollment [enrollmentKey=" + enrollmentKey + ", student=" + student.getStudentId() + ", course="
				+ course.getCourseId() + "]";
	}
}
