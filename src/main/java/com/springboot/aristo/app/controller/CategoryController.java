package com.springboot.aristo.app.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.aristo.app.dto.Category;
import com.springboot.aristo.app.service.CategoryService;

@RestController
@CrossOrigin
@RequestMapping("/api/category")
public class CategoryController {
	
	
	private CategoryService categoryService;
	
	
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}


	@GetMapping
	public ResponseEntity <List<Category>> getAllCategories()
	{
		
		return new ResponseEntity<List<Category>>(categoryService.getAllCategory(), HttpStatus.OK);
	}
	
}
