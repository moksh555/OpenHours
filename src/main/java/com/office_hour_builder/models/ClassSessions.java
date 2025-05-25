package com.office_hour_builder.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="classes")
public class ClassSessions {
	
	private String email;
	
	private String day;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;

	public ClassSessions(String email, String day, LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.email = email;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	
	
	
	
}
