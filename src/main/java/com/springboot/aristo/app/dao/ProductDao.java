package com.springboot.aristo.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.springboot.aristo.app.dto.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{ 
	
	@Query(value="CALL getAllProducts();", nativeQuery=true)
	List<Product> getAllProducts();
	
	@Query(value="CALL getProduct(:id_in);", nativeQuery=true)
	Product getProduct(@Param("id_in") int id) ;
	
	

}
