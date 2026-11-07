package com.college.student.service;

import java.util.List;

import com.college.student.model.Course;

public interface CourseService {

	// Insert
	public abstract Course createCoursetInfo(Course c);

	// Read Or Retrieve All
	public abstract List<Course> getAllCourseDetails();

	// Read Or Retrieve Based On Condition
	public abstract Course getCourseById(Integer cId);

	// Update Course Info
	public abstract Course updateCourseInfo(Course c, Integer cId);

	// Delete Course Info
	public abstract void deleteCourseById(Integer cId);

}
