package com.yac.ex25_brunch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yac.ex25_brunch.domain.Student;
import com.yac.ex25_brunch.service.StudentService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

	// 학생의 전체 목록 보기 화면
	@GetMapping
	public String list(Model model) {
		model.addAttribute("students", studentService.getAllStudents());

		// 화면의 경로와 이름
		return "student/list";
	}

	@GetMapping("/new")
	public String createForm(Model model) {
		model.addAttribute("student", new Student());
		return "student/form";

	}

// form 저장 버튼 클릭 : 한명의 학생을 등록 처리하기
	@PostMapping
		public String create(@ModelAttribute Student student ) {
		studentService.createStudent(student);
		return "redirect:/students";	
		}
	
	// list 화면에서 수정 버튼을 누르면 - form화면: 함녕의 학생의 정보를 보여준다. > http://localhost:8085/students/19/edit
	@GetMapping("/{id}/edit")
	public String updateForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudent(id));
		return "student/form";

	}
	
	//수정 처리
	@PostMapping("/{id}")
	public String update(@PathVariable Long id, @ModelAttribute Student student) {
		student.setId(id);
		studentService.updateStudent(student);
		return "redirect:/students";
	}
	
	//삭제 처리
	@PostMapping("/{id}/delete")
	public String delete(@PathVariable Long id) {
		studentService.deleteStudent(id);

		return "redirect:/students";
	}
	
	
	
	}
	
	
	
	
