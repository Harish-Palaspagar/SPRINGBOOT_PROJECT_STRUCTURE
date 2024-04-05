package com.user.service.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.entities.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.repositories.UserRepository;
import com.user.service.services.UserService;

@Service
public class UserImplementation implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		
		// to generate unique userId
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository
				.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepository
				.findAll();	
	}

	@Override
	public User getUser(String userId) {
		
		return userRepository
				.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User with id " + userId + " not found"));
	}

	@Override
	public void deleteUser(String userId) {
		
		User userToDelete = userRepository.findById(userId)
				     .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " not found"));
                      userRepository.delete(userToDelete);  		
	               
	
	}

	@Override
	public User updateUser(String userId, User userDetails) {
	
		 User user = userRepository.findById(userId)
		            .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " not found"));
		    user.setUserName(userDetails.getUserName());
		    user.setUserEmail(userDetails.getUserEmail());
		    user.setUserAbout(userDetails.getUserAbout());
		    return userRepository.save(user);
	}

}
