package com.codingdojo.danaaltier.studentRoster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.danaaltier.studentRoster.models.Contact;
import com.codingdojo.danaaltier.studentRoster.models.Student;
import com.codingdojo.danaaltier.studentRoster.services.StudentService;

@Controller
public class MainController {
	
	// Adding the student service as  dependency
	private final StudentService studentService;
	
	
	// Constructor
	public MainController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	
	// Methods
	// Redirect
	@RequestMapping("/")
	public String index() {
		return "redirect:/students";
	}
	
	
	// GET route for all students
	@RequestMapping("/students")
 	// Model used for instantiating and binding to our view model
	public String index(Model model) {
		model.addAttribute("students", studentService.getStudents());
		return "students.jsp";
	}
	
	
	// GET route for creating a new student
	@RequestMapping("/students/new")
	public String newStudent(@ModelAttribute("student") Student student) {
		return "newStudent.jsp";
	}
	
	
	// POST route for creating a new student
	@PostMapping("/students/new")
  	// @Valid checks for validation
  	// @BindingResult after, checks for errors
	public String addNewStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		// Event handler for error checking
		if (result.hasErrors()) {
			return "newStudent.jsp"; 
		} else {
			studentService.createStudent(student);
			return "redirect:/";
		}
	}
	
	
	// GET route for creating new contact
	@RequestMapping("/contact/new")
	public String newContact(@ModelAttribute("contact") Contact contact, Model model) {
		List<Student> students = studentService.getStudents();
		model.addAttribute("students", students);
		return "newContact.jsp";
	}
	
	
	// POST route for creating a new contact
	@PostMapping("/contact/new")
  	// @Valid checks for validation
  	// @BindingResult after, checks for errors
	public String createContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result) {
		if (result.hasErrors())
			return "newContact.jsp";
		studentService.createContact(contact);
		return "redirect:/";
	}
}
