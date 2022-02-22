package com.springboot.aristo.app.service.impl;
 

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.aristo.app.dao.UserRepository;
import com.springboot.aristo.app.dto.ApiUser;
import com.springboot.aristo.app.dto.request.UserCreateRequest;
import com.springboot.aristo.app.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
   
    @Override
   public ApiUser readUserByUsername (String username) {
        return userRepository.findByUsernameAndEnabled(username,true).orElseThrow(EntityNotFoundException::new);
        
        
    }

    
   @Override
    public void createUser(UserCreateRequest userCreateRequest) {
        ApiUser apiUser = new ApiUser();
        Optional<ApiUser> byUsername = userRepository.findByUsernameAndEnabled(userCreateRequest.getUsername(),true);
        if (byUsername.isPresent()) {
            throw new RuntimeException("User already registered. Please use different username.");
        }
        apiUser.setUsername(userCreateRequest.getUsername());
        apiUser.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
        apiUser.setRole(userCreateRequest.getRole());
        apiUser.setEmail(userCreateRequest.getEmail());
        apiUser.setPhone(userCreateRequest.getPhone());
        apiUser.setCity(userCreateRequest.getCity());
        apiUser.setState(userCreateRequest.getState());
        apiUser.setEnabled(true);
        userRepository.save(apiUser);
    }
    
    @Override
    public List<ApiUser> getAllUsers()
    {
    	return userRepository.findAll();
    }



	@Override
	public ApiUser getUserById(long id) {
		Optional<ApiUser> user = userRepository.findById(id);
		return user.get();
	}
}