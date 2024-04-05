package com.user.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entities.User;
import com.user.service.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//creating user
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	//getting single user by userId
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId)//if we used different variable in the parameter then give that name after @PathVariable we are using same so we do  have to do it
	{
		User user2 = userService.getUser(userId);
		return ResponseEntity.ok(user2);
	}
	
	//getting all users
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> allUsers = userService.getAllUser();
		return ResponseEntity.ok(allUsers);
	}
	
	// deleting user by userId
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable String userId)
	{
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	//updating user by userId
	
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable String userId,@RequestBody User userDetails)
	{
		User updatedUser = userService.updateUser(userId, userDetails);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	

}
