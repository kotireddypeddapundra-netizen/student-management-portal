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

import com.college.student.model.Student;
import com.college.student.service.StudentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/hi")
	String hello() {
		return "Use Portal For CJITS College Students";
	}

	@PostMapping("/insert")
	Student createStudent(@RequestBody Student s) {
		return studentService.createStudentInfo(s);
	}

	@PostMapping("/insertmany")
	List<Student> createManyStudents(@RequestBody List<Student> students) {
		return studentService.createManyStudents(students);
	}

	@GetMapping("/selectall")
	List<Student> retriveAll() {
		return studentService.getAllStudentsDetails();
	}

	@GetMapping("/selectbyid/{sId}")
	Student retriveById(@PathVariable Integer sId) {
		return studentService.getStudentById(sId);
	}

	@GetMapping("/bycourse/{cId}")
	List<Student> retriveByCourseId(@PathVariable Integer cId) {
		return studentService.getAllStudentsbyCId(cId);
	}

	@PutMapping("/update/{sId}")
	Student update(@RequestBody Student s, @PathVariable Integer sId) {
		return studentService.updateStudentInfo(s, sId);
	}

	@DeleteMapping("/delete/{sId}")
	String delete(@PathVariable Integer sId) {
		studentService.deleteStudentById(sId);
		return "Deleted Successfully";
	}

}
