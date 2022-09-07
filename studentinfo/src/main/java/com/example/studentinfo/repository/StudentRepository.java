package com.example.studentinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentinfo.entity.Student;

public interface StudentRepository extends JpaRepository<Student ,Long> {

}
