package com.yac.ex25_brunch.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yac.ex25_brunch.domain.Student;
import com.yac.ex25_brunch.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentRestController {

	private final StudentService studentService;

//	@GetMapping
//	public Integer list() {
//		return studentService.getMyInteger();
//}

//	@GetMapping
//	public MyStudent myStudent() {
//		return studentService.getStudents();
//}

//	@GetMapping
//		public String myStudent() {
//			return studentService.getStudentName();
//	}

	@GetMapping
	public List<Student> list() {
		return studentService.getAllStudents();

	}

	// http://localhost:8085/api/students/29
	@GetMapping("/{id}")
	public ResponseEntity<Student> detail(@PathVariable Long id) {
		Student student = studentService.getStudent(id);

		return ResponseEntity.ok(student);

	}

	// http://localhost:8085/api/students 포스맨으로
	@PostMapping
	public ResponseEntity<Student> create(@RequestBody Student student) {

		studentService.createStudent(student);
		return ResponseEntity.ok(student);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
		student.setId(id);
		studentService.updateStudent(student);
		return ResponseEntity.ok(student);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		studentService.deleteStudent(id);
		return ResponseEntity.ok().build();
	
	
}
}
