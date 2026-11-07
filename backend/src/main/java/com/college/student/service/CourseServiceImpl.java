package com.college.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.student.model.Course;
import com.college.student.model.Student;
import com.college.student.repo.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepo courseRepo;

	@Override
	public Course createCoursetInfo(Course c) {
		if (c.getStudents() != null) {
			for (Student s : c.getStudents()) {
				s.setCourse(c);
			}
		}
		return courseRepo.save(c);
	}

	@Override
	public List<Course> getAllCourseDetails() {
		return courseRepo.findAll();
	}

	@Override
	public Course getCourseById(Integer cId) {
		return courseRepo.findById(cId)
				.orElseThrow(() -> new RuntimeException("Course not found with ID: " + cId));
	}

	@Override
	public Course updateCourseInfo(Course c, Integer cId) {
		Course courseFromDb = getCourseById(cId);

		if (c.getcName() != null) {
			courseFromDb.setcName(c.getcName());
		}

		if (c.getStudents() != null) {
			for (Student s : c.getStudents()) {
				s.setCourse(courseFromDb);
			}
			courseFromDb.setStudents(c.getStudents());
		}

		return courseRepo.save(courseFromDb);
	}

	@Override
	public void deleteCourseById(Integer cId) {
		courseRepo.deleteById(cId);
	}

}
