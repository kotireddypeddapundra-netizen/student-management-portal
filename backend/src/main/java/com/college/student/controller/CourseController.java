package com.college.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.model.Course;
import com.college.student.service.CourseService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService courseService;

	@PostMapping("/insert")
	Course insert(@RequestBody Course c) {
		return courseService.createCoursetInfo(c);
	}

	@GetMapping("/selectall")
	List<Course> selectAll() {
		return courseService.getAllCourseDetails();
	}

	@GetMapping("/selectbyid/{cId}")
	Course selectById(@PathVariable Integer cId) {
		return courseService.getCourseById(cId);
	}

	@PutMapping("/update/{cId}")
	Course update(@RequestBody Course c, @PathVariable Integer cId) {
		return courseService.updateCourseInfo(c, cId);
	}

	@DeleteMapping("/delete/{cId}")
	String delete(@PathVariable Integer cId) {
		courseService.deleteCourseById(cId);
		return "Course Deleted Successfully";
	}

}
