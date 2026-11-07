package com.college.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.student.model.Course;
import com.college.student.model.Student;
import com.college.student.repo.CourseRepo;
import com.college.student.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo studentRepo;

	@Autowired
	CourseRepo courseRepo;

	@Override
	public Student createStudentInfo(Student s) {

		if (s.getCourse() != null && s.getCourse().getcId() != null) {

			Integer courseId = s.getCourse().getcId();

			Course course = courseRepo.findById(courseId)
					.orElseThrow(() -> new RuntimeException("Course not found with ID: " + courseId));

			s.setCourse(course);
		}

		return studentRepo.save(s);
	}

	@Override
	public List<Student> createManyStudents(List<Student> students) {
		for (Student s : students) {
			if (s.getCourse() != null && s.getCourse().getcId() != null) {
				Integer courseId = s.getCourse().getcId();
				Course course = courseRepo.findById(courseId)
						.orElseThrow(() -> new RuntimeException("Course not found with ID: " + courseId));
				s.setCourse(course);
			}
		}
		return studentRepo.saveAll(students);
	}

	@Override
	public List<Student> getAllStudentsDetails() {
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(Integer sId) {
		return studentRepo.findById(sId)
				.orElseThrow(() -> new RuntimeException("Student not found with ID: " + sId));
	}

	@Override
	public Student updateStudentInfo(Student s, Integer sId) {

		Student studentFromDb = getStudentById(sId);

		studentFromDb.setAge(s.getAge());
		studentFromDb.setBranch(s.getBranch());
		studentFromDb.setEmailId(s.getEmailId());
		studentFromDb.setfName(s.getfName());
		studentFromDb.setlName(s.getlName());
		studentFromDb.setMarks(s.getMarks());
		studentFromDb.setPhnNo(s.getPhnNo());

		if (s.getCourse() != null && s.getCourse().getcId() != null) {

			Integer courseId = s.getCourse().getcId();

			Course course = courseRepo.findById(courseId)
					.orElseThrow(() -> new RuntimeException("Course not found with ID: " + courseId));

			studentFromDb.setCourse(course);
		}

		return studentRepo.save(studentFromDb);
	}

	@Override
	public void deleteStudentById(Integer sId) {
		studentRepo.deleteById(sId);
	}

	@Override
	public List<Student> getAllStudentsbyCId(Integer cId) {
		return studentRepo.getStudentsByCourse_CId(cId);
	}

}
