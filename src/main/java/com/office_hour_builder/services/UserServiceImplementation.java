package com.office_hour_builder.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.office_hour_builder.models.ClassSessions;
import com.office_hour_builder.models.User;
import com.office_hour_builder.repository.UserRepository;

public class UserServiceImplementation implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	private Boolean checkClassSession(User user, ClassSessions session) {
		
		boolean exists = user.getClasses().stream().anyMatch(existing ->
        existing.getDay().equals(session.getDay()) &&
        existing.getStartTime().equals(session.getStartTime()) &&
        existing.getEndTime().equals(session.getEndTime())
				);
		
		return exists;
	}

	@Override
	public User addClass(String jwt, ClassSessions session) {
		User user = findUserByJwt(jwt);
		
		
		Boolean exists = checkClassSession(user, session);
		
		if (!exists) {
			user.getClasses().add(session);
			userRepository.save(user);
		}
		return user;
	}

	@Override
	public User removeClass(String jwt, ClassSessions session) {
		User user = findUserByJwt(jwt);
		
		Boolean exists = checkClassSession(user, session);
		
		if (exists) {
			user.getClasses().removeIf(existing -> 
            existing.getDay().equals(session.getDay()) &&
            existing.getStartTime().equals(session.getStartTime()) &&
            existing.getEndTime().equals(session.getEndTime())
        );
			userRepository.save(user);
		}
		return user;
	}

	@Override
	public User findUserByJwt(String jwt) {
//		String email = JwtProvider.getEmailFromJwtToken(jwt);
//		
//		User user = userRepository.findByEmail(email);
		return null;
	}
}
