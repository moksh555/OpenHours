package com.office_hour_builder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.office_hour_builder.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}
