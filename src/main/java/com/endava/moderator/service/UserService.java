package com.endava.moderator.service;

import java.util.List;

import com.endava.moderator.model.User;

public interface  UserService {
	
	List<User> findAll();

	User save(User user);

	User findByUsername(String username);
}
