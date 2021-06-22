package com.codingdojo.danaaltier.studentRoster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.danaaltier.studentRoster.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	List<Student> findAll();
	
}
