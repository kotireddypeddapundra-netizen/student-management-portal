package com.college.student.service;

import java.util.List;

import com.college.student.model.Student;

public interface StudentService {

	// Insert
	public abstract Student createStudentInfo(Student s);

	// Insert Many
	public abstract List<Student> createManyStudents(List<Student> students);

	// Read Or Retrieve All
	public abstract List<Student> getAllStudentsDetails();

	// Read Or Retrieve Based On Condition
	public abstract Student getStudentById(Integer sId);

	// Update Student Info
	public abstract Student updateStudentInfo(Student s, Integer sId);

	// Delete Student Info
	public abstract void deleteStudentById(Integer sId);

	// Retrieve Students By Course ID
	public abstract List<Student> getAllStudentsbyCId(Integer cId);

}
