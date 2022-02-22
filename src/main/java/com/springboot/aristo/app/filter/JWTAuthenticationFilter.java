package com.springboot.aristo.app.filter;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.aristo.app.config.AuthenticationConfigConstants;
import com.springboot.aristo.app.dto.ApiUser;
import com.springboot.aristo.app.exception.ResourceNotFoundException;
import com.springboot.aristo.app.service.impl.UserDetailsImpl;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
 

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 


// @RequiredArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

        setFilterProcessesUrl("/api/user/login"); 
    }

    
    
    @Override public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            ApiUser creds = new ObjectMapper()
                .readValue(request.getInputStream(), ApiUser.class);

            
            return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    creds.getUsername(),
                    creds.getPassword(),
                    new ArrayList<>())
            );
        } catch (IOException e) {
            //throw new RuntimeException(e);
        	throw new ResourceNotFoundException(request.getRequestURI(), "Token not found", 1) ;
        }
    }

    @Override protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {
        String token = JWT.create()
            .withSubject(((UserDetailsImpl) auth.getPrincipal()).getUsername())
            .withClaim("role", auth.getAuthorities().iterator().next().getAuthority())
            .withExpiresAt(new Date(System.currentTimeMillis() + AuthenticationConfigConstants.EXPIRATION_TIME))
            .sign(Algorithm.HMAC512(AuthenticationConfigConstants.SECRET.getBytes()));

        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();	
        System.out.println(userDetails.getEmail());
        System.out.println(userDetails.getId());
            
        //START - SENDING JWT AS A BODY
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(
            "{\"" + AuthenticationConfigConstants.HEADER_STRING + "\":\"" + AuthenticationConfigConstants.TOKEN_PREFIX + token + "\","+
            		"\"user\":\"" +userDetails.getUsername()+"\","+
            		"\"email\":\"" +userDetails.getEmail()+"\","+
            		"\"id\":\"" +userDetails.getId()+"\","+
            		"\"role\":\"" +auth.getAuthorities().iterator().next().getAuthority()+"\"}"
        );
        
        
        //END - SENDING JWT AS A BODY

        //START - SENDING JWT AS A HEADER
        response.addHeader(AuthenticationConfigConstants.HEADER_STRING, AuthenticationConfigConstants.TOKEN_PREFIX + token);
        //END - SENDING JWT AS A HEADER
    }
}