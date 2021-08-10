package com.starmanw.common.dataloader.data;

import java.util.ArrayList;
import java.util.List;

import com.starmanw.entity.Student;

public class StudentData {
	public static final List<Student> STUDENTS = new ArrayList<Student>() {
		{
			add(new Student("18WMR12001", "StarmanW", "2019/2020"));
			add(new Student("18WMR12002", "Michelle", "2019/2020"));
			add(new Student("18WMR12003", "Johannsen", "2020/2021"));
			add(new Student("18WMR12004", "Orbiter", "2020/2021"));
			add(new Student("18WMR12005", "Jenny", "2020/2021"));
		}
	};
}
