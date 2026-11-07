package com.college.student.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.college.student.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

	@Query("SELECT s FROM Student s WHERE s.course.cId = :cId")
	List<Student> getStudentsByCourse_CId(@Param("cId") Integer cId);

}
