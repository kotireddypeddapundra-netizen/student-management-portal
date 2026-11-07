package com.college.student;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.college.student.model.Course;
import com.college.student.model.Student;
import com.college.student.service.CourseService;
import com.college.student.service.StudentService;

@SpringBootTest
class StudentApplicationTests {

	@Autowired
	private CourseService courseService;

	@Autowired
	private StudentService studentService;

	@Test
	void testInsertManyStudentsInOneCourseAndCrud() {
		// 1. Create a course with multiple students
		Course course = new Course();
		course.setcName("Artificial Intelligence");

		Student s1 = new Student();
		s1.setfName("Alice");
		s1.setlName("Johnson");
		s1.setBranch("CSE");
		s1.setAge(21);
		s1.setMarks(92);
		s1.setEmailId("alice.j@college.edu");
		s1.setPhnNo(9876543210L);

		Student s2 = new Student();
		s2.setfName("Bob");
		s2.setlName("Williams");
		s2.setBranch("CSE");
		s2.setAge(22);
		s2.setMarks(88);
		s2.setEmailId("bob.w@college.edu");
		s2.setPhnNo(9876543211L);

		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		course.setStudents(students);

		// Insert course with many students
		Course savedCourse = courseService.createCoursetInfo(course);
		assertNotNull(savedCourse.getcId(), "Course ID should not be null after insert");
		assertEquals("Artificial Intelligence", savedCourse.getcName());

		Integer courseId = savedCourse.getcId();

		// 2. Retrieve students for this course
		List<Student> retrievedStudents = studentService.getAllStudentsbyCId(courseId);
		assertEquals(2, retrievedStudents.size(), "Should have retrieved 2 students for the course");

		// 3. Update course
		savedCourse.setcName("AI & Machine Learning");
		Course updatedCourse = courseService.updateCourseInfo(savedCourse, courseId);
		assertEquals("AI & Machine Learning", updatedCourse.getcName());

		// 4. Update student
		Student firstStudent = retrievedStudents.get(0);
		firstStudent.setMarks(98);
		Student updatedStudent = studentService.updateStudentInfo(firstStudent, firstStudent.getsId());
		assertEquals(98, updatedStudent.getMarks());

		// 5. Retrieve student by ID
		Student retrievedStudent = studentService.getStudentById(firstStudent.getsId());
		assertNotNull(retrievedStudent);
		assertEquals("Alice", retrievedStudent.getfName());
		assertEquals(courseId, retrievedStudent.getCourse().getcId());

		// 6. Insert another student into this existing course
		Student s3 = new Student();
		s3.setfName("Charlie");
		s3.setlName("Brown");
		s3.setBranch("AI");
		s3.setAge(20);
		s3.setMarks(85);
		s3.setEmailId("charlie@college.edu");
		s3.setPhnNo(9876543212L);

		Course courseRef = new Course();
		courseRef.setcId(courseId);
		s3.setCourse(courseRef);

		Student savedS3 = studentService.createStudentInfo(s3);
		assertNotNull(savedS3.getsId());
		assertEquals(courseId, savedS3.getCourse().getcId());

		// Verify count is now 3
		List<Student> threeStudents = studentService.getAllStudentsbyCId(courseId);
		assertEquals(3, threeStudents.size());

		// 7. Delete one student
		studentService.deleteStudentById(savedS3.getsId());
		List<Student> afterDeleteStudents = studentService.getAllStudentsbyCId(courseId);
		assertEquals(2, afterDeleteStudents.size());

		// 8. Delete course
		courseService.deleteCourseById(courseId);
		assertThrows(RuntimeException.class, () -> courseService.getCourseById(courseId));
	}

}
