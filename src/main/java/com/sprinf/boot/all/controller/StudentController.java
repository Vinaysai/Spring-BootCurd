package com.sprinf.boot.all.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprinf.boot.all.bean.StudentBean;
import com.sprinf.boot.all.entity.Student;
import com.sprinf.boot.all.exception.ResourceNotFoundException;
import com.sprinf.boot.all.repository.StudentRepository;
import com.sprinf.boot.all.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	public StudentService service;

	@Autowired
	public StudentRepository studentRepository;
	
	 /* @GetMapping(value = "/hello")
	   public String greeting() {
	    return "hello Spring boot";
	 
	  }
	  
	  @RequestMapping("/testuser/{id}")
	   public String greetingsto(@PathVariable("id")String userID)
	   {
	    return "hello again   " + userID;
	  }
	  
	  
	  @RequestMapping("/testuser")
	   public String greetings(@RequestParam("userID")String userID)
	   {
	    return "hello again   " + userID;
	  }*/
	  
	 /* @RequestMapping("/greet/{userid}/{coursename}")
	   public String greet(@RequestParam("userid") String userid, @RequestParam("coursename")String coursename)
	    {
	     return userid + "hi there..." + coursename;
	  }*/
	 

	/******** Insert/Update a Record USing POST **********/

	// @RequestMapping(value = "/api/create", method = RequestMethod.PUT, consumes ="application/json", produces = "application/json")

	@PutMapping(value = "/api/create", consumes = "application/json", produces = "application/json")
	public Student insertStudent(@RequestBody StudentBean bean) {

		Student insert = service.insert(bean);
		return insert;
	}
	
	
	/********Update A Record**********/
	
	@PutMapping(value="/api/client/update/{id}")
	public Student update(@PathVariable("id") String id,@RequestBody StudentBean s) {

		Student student = studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("StudentBean","id",id));
		
		student.setName(s.getFirstname());
		student.setQualification(s.getQualification());
		
		Student st=studentRepository.save(student);
		
		return st;
	}
	

	/************ Delete a Record Using Id *********/

	// @RequestMapping(value="/api/client/delete/{id}")

	@DeleteMapping(value = "/api/client/delete/{id}")
	public String delete(@PathVariable("id") String id) {

		String delete = service.delete(id);
		if (delete == null)
			return "fail";
		else
			return "success";

	}

	/******** View List Of Records *******/

	// @RequestMapping(value="/api/client/retriveallclients" ,produces ="application/json")

	@GetMapping(value = "/api/client/retriveallclients", produces = "application/json")
	public List<Student> findAll() {

		List<Student> viewList = service.findAll();
		return viewList;
	}

	/********* Get A Particular Record *****************/

	// @RequestMapping(value="/api/client/retriveallclients/{id}" ,produces ="application/json")

	@GetMapping(value = "/api/client/retriveallclients/{id}", produces = "application/json")
	public Optional findStudent(@PathVariable("id") String id) {

		Optional findStudent = service.findStudent(id);
		return findStudent;

	}

}