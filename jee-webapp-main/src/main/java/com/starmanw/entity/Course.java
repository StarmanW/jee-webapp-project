package com.starmanw.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "COURSE")
public class Course implements Serializable {
	@Id
	@Column(name = "COURSE_KEY")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COURSE_GENERATOR")
	@SequenceGenerator(name = "COURSE_GENERATOR", sequenceName = "COURSE_SEQ")
	private long courseKey;

	@Column(name = "COURSE_ID", nullable = false, unique = true, length = 8)
	private String courseId;

	@Column(name = "COURSE_NAME", nullable = false, length = 255)
	private String courseName;

	@Column(name = "COURSE_CREDIT_HOUR")
	private int courseCreditHour;

	@OneToMany(mappedBy = "course")
	private List<Enrollment> enrollments;

	public Course() {
	}

	public Course(String courseId, String courseName, int courseCreditHour) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseCreditHour = courseCreditHour;
	}

	/** Getter for courseId */
	public String getCourseId() {
		return courseId;
	}

	/** Setter for courseId */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/** Getter for courseName */
	public String getCourseName() {
		return courseName;
	}

	/** Setter for courseName */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/** Getter for courseCreditHour */
	public int getCourseCreditHour() {
		return courseCreditHour;
	}

	/** Setter for courseCreditHour */
	public void setCourseCreditHour(int courseCreditHour) {
		this.courseCreditHour = courseCreditHour;
	}

	@Override
	public String toString() {
		return "Course [courseKey=" + courseKey + ", courseId=" + courseId + ", courseName=" + courseName
				+ ", courseCreditHour=" + courseCreditHour + "]";
	}
}
