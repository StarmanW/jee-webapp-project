package com.starmanw.common.dataloader.data;

import java.util.ArrayList;
import java.util.List;

import com.starmanw.entity.Course;

public class CourseData {
	public static final List<Course> COURSES = new ArrayList<Course>() {
		{
			add(new Course("AACS2011", "Introduction to Computer Network", 2));
			add(new Course("BAIT3113", "Advanced Programming Technique", 3));
			add(new Course("AACS3431", "Web Application Development", 3));
			add(new Course("AACS3111", "Data Structure & Algorithm", 3));
		}
	};
}
