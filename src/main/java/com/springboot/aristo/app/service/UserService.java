package com.springboot.aristo.app.service;

import java.util.List;

import com.springboot.aristo.app.dto.ApiUser;
import com.springboot.aristo.app.dto.RoleCombo;
import com.springboot.aristo.app.dto.request.UserCreateRequest;

public interface UserService {

	
	 public ApiUser readUserByUsername (String username);
	 public void createUser(UserCreateRequest userCreateRequest);
	 public List<ApiUser> getAllUsers();
	 public ApiUser getUserById(long id);
  	 List<RoleCombo> getAllRole(Long state_code,String role);
  	 boolean existsCode(String code);
  	 
	 
}
