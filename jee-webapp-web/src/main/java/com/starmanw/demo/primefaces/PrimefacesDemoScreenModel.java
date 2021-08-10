package com.starmanw.demo.primefaces;

import jakarta.enterprise.context.Dependent;

@Dependent
public class PrimefacesDemoScreenModel {
	private String studentId;
	private String studentName;

	public PrimefacesDemoScreenModel() {
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
