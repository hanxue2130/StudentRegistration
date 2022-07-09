package com.mthree.StudentWithFront.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.mthree.StudentWithFront.Student;
import com.mthree.StudentWithFront.service.IService;


@CrossOrigin
@RestController
public class StudentResource {
	
	@Autowired
	private IService service;
	
	@RequestMapping("/")
	public ModelAndView index () {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("student");
	    return modelAndView;
	}
	
	@GetMapping(path = "/students")
	public List<Student> retrieveAllUsers(){;
		return service.findAll();
	}	

	@PostMapping(path = "/students")
	public Student createUser(@RequestBody Student stu, BindingResult result, Model model) {
		return service.save(stu);	
	}
	

	@GetMapping(path ="/students/{id}" )
	public Student retrieveUser(@PathVariable int id) {
		Student stu = service.findById(id);
		return stu;
	}
	
	@DeleteMapping(path="/students/{id}")
	public Student removeUser(@PathVariable int id) {
		return service.deleteById(id);
	}
	
	@Transactional
	@PutMapping(path = "/students/{id}")
	public void updateStudentById(@PathVariable int id, @RequestBody Student student) {
		Student s = service.findById(id);
		s.setName(student.getName());
		service.save(s);

	}

}
	

