package com.sbproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbproject.entities.Users;

public interface UsersRepository  extends JpaRepository<Users, Integer>{
	public Users findByEmail(String email);
	

}
