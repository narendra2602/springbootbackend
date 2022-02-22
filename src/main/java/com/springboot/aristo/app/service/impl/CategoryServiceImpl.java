package com.springboot.aristo.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.aristo.app.dao.CategoryDao;
import com.springboot.aristo.app.dto.Category;
import com.springboot.aristo.app.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

}
