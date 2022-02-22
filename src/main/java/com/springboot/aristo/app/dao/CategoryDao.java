package com.springboot.aristo.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.aristo.app.dto.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{

	
	
}
