package com.office_hour_builder.services;

import com.office_hour_builder.models.ClassSessions;
import com.office_hour_builder.models.User;

public interface Professor {
	
	public User addGrader(User user);
	
	public User getAllStudents(User user);
	
	public User getAllStudentdsByClass(Integer classId);
	
	public User addUserSession(Integer userId, ClassSessions session);
	
	public User changeUserSession(Integer userId, ClassSessions session);
}
