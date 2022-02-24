package com.springboot.aristo.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.aristo.app.dto.ApiUser;
import com.springboot.aristo.app.dto.RoleCombo;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<ApiUser, Long> {
    //Optional<ApiUser> findByUsername(String username);
	Optional<ApiUser> findByUsernameAndEnabled(String username,boolean active);
  
    
	@Query(value="CALL getAllRole(:state_in,:role_in);", nativeQuery=true)
	List<RoleCombo> getAllRole(@Param("state_in") Long id,@Param("role_in") String role) ;
	
}