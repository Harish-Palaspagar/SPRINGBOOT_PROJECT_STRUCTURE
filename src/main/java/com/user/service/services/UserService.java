package com.user.service.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.service.entities.User;


@Service
public interface UserService {
	
	//user operations
	
	//create user
	
	User saveUser(User user);
	
	//get all user
	
	List<User> getAllUser();
	
	//get user by userId;
	
	User getUser(String userId);

	//delete user by userId
	
	void deleteUser(String userId);
	
	//update user by userId
	
	User updateUser(String userId, User userDetails);
	
	

}
