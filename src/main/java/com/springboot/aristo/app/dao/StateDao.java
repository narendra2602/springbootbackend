package com.springboot.aristo.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.aristo.app.dto.State;

public interface StateDao extends JpaRepository<State, Integer>{
      
	    List<State> findByOrderByLabelAsc();
	    
}
