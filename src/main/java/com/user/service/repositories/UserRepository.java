package com.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.service.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	//custom finder methods here
	// we are creating our own id check implementation class for that
	

}
