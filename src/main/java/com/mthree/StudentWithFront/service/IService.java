package com.mthree.StudentWithFront.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.mthree.StudentWithFront.Student;




public interface IService {
	public List<Student> findAll();
	public Student save(Student stu);
	public Student findById(int id);
	public Student deleteById(int id);

}
