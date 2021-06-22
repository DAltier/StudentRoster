package com.codingdojo.danaaltier.studentRoster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.danaaltier.studentRoster.models.Contact;
import com.codingdojo.danaaltier.studentRoster.models.Student;
import com.codingdojo.danaaltier.studentRoster.repositories.ContactRepository;
import com.codingdojo.danaaltier.studentRoster.repositories.StudentRepository;

@Service
public class StudentService {

	// Adding the student and contact repositories as  dependencies
	private StudentRepository studentRepo;
	private ContactRepository contactRepo;
	
	
	// Constructor
	public StudentService(StudentRepository studentRepo, ContactRepository contactRepo) {
		this.studentRepo = studentRepo;
		this.contactRepo = contactRepo;
	}
	
	
	// Create new student
	public Student createStudent(Student s) {
		return studentRepo.save(s);
	}
	
	
	// Create new contact
	public Contact createContact(Contact c) {
		return contactRepo.save(c);	
	}
	
	
	// GET all students
	public List<Student> getStudents(){
		return studentRepo.findAll();
	}
	
	
	// GET one student by Id
	public Student findStudent(Long id) {
		Optional<Student> optionalStudent = studentRepo.findById(id);
		if(optionalStudent.isPresent()) {
			return optionalStudent.get();
		} else {
			return null;
		}
	}
}
