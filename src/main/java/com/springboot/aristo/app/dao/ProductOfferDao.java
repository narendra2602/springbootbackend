package com.springboot.aristo.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.springboot.aristo.app.dto.ProductOffer;
@EnableJpaRepositories
@Repository
public interface ProductOfferDao extends JpaRepository<ProductOffer, Integer>{
	
	@Query(value="CALL getProductOffer();", nativeQuery=true)
	List<ProductOffer> getProductOffer();
	

}
