package com.codingdojo.danaaltier.studentRoster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.danaaltier.studentRoster.models.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	List<Contact> findAll();
	
}
