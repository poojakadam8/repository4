package com.example.studentinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentinfo.entity.Student;
import com.example.studentinfo.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping
	public ResponseEntity<Student> saveStudent( @RequestBody Student student){
		return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);
	}
	@GetMapping
	public List<Student> getStudentList(){
		return studentService.getStudentList();
	}
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable("id")long id) {
		return studentService.getStudentById(id);
		
	}
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable("id")long id, @RequestBody Student student) {
		return studentService.updateDoctor(id,student);
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable("id")long id) {
		return studentService.deleteStudent(id);
		
	}
}
