package com.codingdojo.danaaltier.studentRoster.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="contacts")
public class Contact {
	
	// Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String address;
	private String city;
	private String state;
	private Date createdAt;
	private Date updatedAt;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_id")
	private Student student;
	
	
	// Constructors 
	public Contact () {
		
	}
	public Contact(String address, String city, String state, Student student) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.student = student;
	}
	
	
	// Getters
	public Long getId() {
		return id;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public Student getStudent() {
		return student;
	}
	
	
	// Setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	// Methods
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
