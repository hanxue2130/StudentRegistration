package com.mthree.StudentWithFront.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.mthree.StudentWithFront.Student;


@Repository(value = "stujaprepos")
public interface StudentJPARepository extends IDAO, JpaRepository<Student, Integer> {

}
	