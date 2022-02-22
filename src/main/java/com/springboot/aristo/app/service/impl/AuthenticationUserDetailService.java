package com.springboot.aristo.app.service.impl;
 

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.aristo.app.dto.ApiUser;

import java.util.Arrays;
import java.util.Collection;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationUserDetailService implements UserDetailsService {

    private final UserServiceImpl userService;
//
//    @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        ApiUser apiUser = userService.readUserByUsername(username);
//        if (apiUser == null) {
//            throw new UsernameNotFoundException(username);
//        }
//       
//        
////        return new org.springframework.security.core.userdetails.User(apiUser.getUsername(),
////            apiUser.getPassword(), getAuthorities(apiUser.getRole()));
//        
//		return UserDetailsImpl.build(apiUser);
//        
//    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApiUser user = userService.readUserByUsername(username);
		 if (user == null) {
	            throw new UsernameNotFoundException(username);
	        }
				
		return UserDetailsImpl.build(user);
	}

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }
}