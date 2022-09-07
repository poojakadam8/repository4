package com.example.studentinfo.service;

import java.util.List;

import com.example.studentinfo.entity.Student;

public interface StudentService {

	Student saveStudent(Student student);

	List<Student> getStudentList();

	Student getStudentById(long id);

	Student updateDoctor(long id, Student student);

	String deleteStudent(long id);


}
