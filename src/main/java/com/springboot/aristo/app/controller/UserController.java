package com.springboot.aristo.app.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.aristo.app.dto.ApiUser;
import com.springboot.aristo.app.dto.RoleCombo;
import com.springboot.aristo.app.dto.request.UserCreateRequest;
import com.springboot.aristo.app.service.UserService;


import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
 
	
    
    @PostMapping
    public ResponseEntity<UserCreateRequest> createUser (@RequestBody UserCreateRequest userCreateRequest) {
        userService.createUser(userCreateRequest);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping
    public ResponseEntity<List<ApiUser>> getAllUsers()
    {
    	return new ResponseEntity<List<ApiUser>>(userService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiUser> getUserById(@PathVariable("id") long id)
    {
    	return new ResponseEntity<ApiUser>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("{state_code}/{role}")
    public ResponseEntity<List<RoleCombo>> getAllRole(@PathVariable("state_code") long state_code,@PathVariable("role") String role)
    {
    	return new ResponseEntity<List<RoleCombo>>(userService.getAllRole(state_code,role),HttpStatus.OK);
    }
    
    @GetMapping("exist/{code}")
    public ResponseEntity<Map<String,Boolean>> existsCode(@PathVariable("code") String code)
    {
    	boolean exist = userService.existsCode(code);
		Map<String,Boolean> response = new HashMap<String,Boolean>();
		response.put("Found", exist);
		return  ResponseEntity.ok(response);

    	//return new ResponseEntity<List<RoleCombo>>(userService.existsCode(code),HttpStatus.OK);
    }

    
}


