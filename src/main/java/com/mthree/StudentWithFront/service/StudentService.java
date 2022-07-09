package com.mthree.StudentWithFront.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.mthree.StudentWithFront.Student;
import com.mthree.StudentWithFront.dao.IDAO;
import com.mthree.exceptionhandling.StudentException;



@Service
public class StudentService implements IService {
	
	@Autowired
	@Qualifier(value = "stujaprepos")
	private IDAO dao;

	
	@Override
	public List<Student> findAll() {
		if(dao.findAll()==null) {
			throw new StudentException("no student found");
		}
		return dao.findAll();
		
	}

	@Override
	public Student save(Student stu) {
		System.out.println("Inside save of UserService");
		return dao.save(stu);
	}

	@Override
	public Student findById(int id) {
		if(dao.findById(id)==null) {
			throw new StudentException("no student found");
		}
		return dao.findById(id);
	}

	@Override
	public Student deleteById(int id) {
		if(dao.findById(id)==null) {
			throw new StudentException("no student found");
		}
		return dao.deleteById(id);
	}


}
