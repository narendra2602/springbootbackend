package com.springboot.aristo.app.config;

 
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.springboot.aristo.app.dto.ApiUser;
import com.springboot.aristo.app.filter.JWTAuthenticationFilter;
import com.springboot.aristo.app.filter.JWTAuthorizationFilter;
import com.springboot.aristo.app.service.impl.AuthenticationUserDetailService;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationUserDetailService authenticationUserDetailService;

    @Override protected void configure(HttpSecurity http) throws Exception {
    	/*http.cors().and().csrf().disable().authorizeRequests()
    	
            .antMatchers(HttpMethod.POST, AuthenticationConfigConstants.SIGN_UP_URL).permitAll()
            .antMatchers(HttpMethod.POST, AuthenticationConfigConstants.LOGIN_URL).permitAll()
            .antMatchers(HttpMethod.GET, AuthenticationConfigConstants.HOME_URL).permitAll()
            //ROLE BASED AUTHENTICATION START
//            .antMatchers("/api/library/book/**").hasAnyAuthority("USER", "ADMIN")
//            .antMatchers("/api/library/author/**").hasAnyAuthority("ADMIN")
//            .antMatchers("/api/library/member/**").hasAnyAuthority("ADMIN")
            //ROLE BASED AUTHENTICATION END
            .anyRequest().authenticated()
            .and()
           .addFilter(new JWTAuthenticationFilter(authenticationManager()))
            .addFilter(new JWTAuthorizationFilter(authenticationManager()))
            // this disables session creation on Spring Security
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
    	
    	
    	
    	http.cors().and().csrf().disable().authorizeRequests()
    	  .antMatchers(HttpMethod.POST, AuthenticationConfigConstants.SIGN_UP_URL).permitAll()
          .antMatchers(HttpMethod.GET, AuthenticationConfigConstants.LOGIN_URL).permitAll()
          .antMatchers(HttpMethod.GET, AuthenticationConfigConstants.HOME_URL).permitAll()
          //.antMatchers("/api/employees/delete/**").permitAll()
          .anyRequest().authenticated()
          .and()
          .addFilter(new JWTAuthenticationFilter(authenticationManager()))
          .addFilter(new JWTAuthorizationFilter(authenticationManager()))
          // this disables session creation on Spring Security
          .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    	
    	
    	//Exception handling configuration
    	 
    	http
    	    .exceptionHandling()
    	    .authenticationEntryPoint((request, response, e) -> 
    	    {
    	        response.setContentType("application/json;charset=UTF-8");
    	        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    	        response.getWriter().write(
    	        		 "{\"timestamp\":\"" + LocalDateTime.now()+ "\","+
    	        				 "\"url\":\"" +request.getRequestURL()+"\","+
    	        				 "\"method\":\"" +request.getMethod()+"\","+
    	        				 "\"message\":\"Access Denied or Token Expired\"}"
    	        		);
    	        		
    	    });    	
    	
    	
    }
    

    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

//        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
        corsConfiguration.setAllowedMethods(Arrays.asList("*"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
        
        
        source.registerCorsConfiguration("/**", corsConfiguration);

        return source;
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationUserDetailService).passwordEncoder(bCryptPasswordEncoder);
    }
}