package com.mthree.StudentWithFront;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stu")
public class Student {
	@Id
	@GeneratedValue
	private Integer id;
	@Column
	String name;
	@Column
	String age;
	@Column
	String mobile;
	@Column
	String address;

	public Student () {
		
	}
	public Student(String name, String age, String mobile, String address) {
		super();
//		this.id = id;
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String add) {
		this.mobile = add;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", mobile=" + mobile + ", address=" + address + "]";
	}
}
