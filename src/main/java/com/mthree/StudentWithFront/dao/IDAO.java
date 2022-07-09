package com.mthree.StudentWithFront.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.mthree.StudentWithFront.Student;


public interface IDAO {
	public List<Student> findAll();
	public Student save(Student stu);
	public Student deleteById(int id);
	public Student findById(int id);

}
