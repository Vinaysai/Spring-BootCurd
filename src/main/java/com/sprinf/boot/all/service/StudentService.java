package com.sprinf.boot.all.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinf.boot.all.bean.StudentBean;
import com.sprinf.boot.all.entity.Student;
import com.sprinf.boot.all.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	public StudentRepository studentRepository;

	public Student insert(StudentBean bean) {
		Student student = new Student();
		student.setId(bean.getId());
		student.setName(bean.getFirstname());
		student.setQualification(bean.getQualification());

		studentRepository.save(student);

		return student;
	}
	
	

	public String delete(String id) {

		studentRepository.deleteById(id);

		return id;

	}

	public List<Student> findAll() {

		List<Student> findAll = studentRepository.findAll();

		return findAll;

		
	}
	
	
	public Optional findStudent(String id)
	{
	Optional<Student> findById = studentRepository.findById(id);	
		return findById;
		
	}
}
