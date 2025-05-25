package com.office_hour_builder.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name="Users")
public class User {
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String role;
	
	private String course;
	
	private List<ClassSessions> classes;

	public User(Integer id, String firstName, String lastName, String email, String role, String course,
			List<ClassSessions> classes) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.course = course;
		this.classes = classes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public List<ClassSessions> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassSessions> classes) {
		this.classes = classes;
	}
	
	
	
	
}
