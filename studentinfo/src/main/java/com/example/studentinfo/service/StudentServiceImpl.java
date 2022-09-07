package com.example.studentinfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentinfo.entity.Student;
import com.example.studentinfo.exception.GivenIdNotFoundException;
import com.example.studentinfo.exception.NoRecordFoundException;
import com.example.studentinfo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	StudentRepository studentRepository;
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getStudentList() {
		// TODO Auto-generated method stub
		List<Student> student= studentRepository.findAll();
		if(student.isEmpty())
			throw new NoRecordFoundException();
		else
		return student;
	}

	@Override
	public Student getStudentById(long id) {
		// TODO Auto-generated method stub
		Optional<Student> student=studentRepository.findById(id);
		if(student.isPresent())
		return student.get();
		else
			throw new GivenIdNotFoundException();
	}

	@Override
	public Student updateDoctor(long id, Student student) {
		// TODO Auto-generated method stub
		Student st=studentRepository.findById(id).orElseThrow(()-> new GivenIdNotFoundException());
		st.setFirstName(student.getFirstName());
		st.setLastName(student.getLastName());
		st.setGender(student.getGender());
		st.setAddress(student.getAddress());
		st.setCity(student.getCity());
		studentRepository.save(st);
		return st;
	}

	@Override
	public String deleteStudent(long id) {
		// TODO Auto-generated method stub
		Student student=studentRepository.findById(id).orElseThrow(()-> new GivenIdNotFoundException());
		studentRepository.deleteById(id);
		return "Student Record Deleted Successfully";
	}

}
