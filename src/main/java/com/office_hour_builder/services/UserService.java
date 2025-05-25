package com.office_hour_builder.services;

import com.office_hour_builder.models.ClassSessions;
import com.office_hour_builder.models.User;

public interface UserService {
	
	public User addClass(String jwt, ClassSessions session);
	
	public User removeClass(String jwt, ClassSessions session);
	
	public User findUserByJwt(String jwt);
	
}
