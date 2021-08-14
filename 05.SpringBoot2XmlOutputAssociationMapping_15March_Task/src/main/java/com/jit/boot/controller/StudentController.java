package com.jit.boot.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jit.boot.model.Course;
import com.jit.boot.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	@GetMapping("/data")
	public ResponseEntity<Student> getStudentData() {
		Student body = new Student(1, "Jitendra", Set.of("Java", "Spring", "Hibernate", "Jdbc"),
				List.of(76, 87, 98, 65), Map.of("JAVA", "A", "Spring", "A", "Hibernate", "D", "Jdbc", "E"),
				new Course(100, "B.tech", 89000.89));
		return new ResponseEntity<Student>(body, HttpStatus.OK);
	}
}
