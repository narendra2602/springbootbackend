package com.springboot.aristo.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.aristo.app.dto.ApiUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ApiUser, Long> {
    //Optional<ApiUser> findByUsername(String username);
	Optional<ApiUser> findByUsernameAndEnabled(String username,boolean active);
  
    
    
}