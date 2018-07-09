package com.sprinf.boot.all.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprinf.boot.all.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {


}
