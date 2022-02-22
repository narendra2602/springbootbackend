package com.springboot.aristo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.aristo.app.dto.ProductOffer;
import com.springboot.aristo.app.service.ProductOfferService;

@RestController
@CrossOrigin
@RequestMapping("/api/offer")
public class ProductOfferController {
	
	@Autowired
	private ProductOfferService productOfferService;

	
	@GetMapping()
	public List<ProductOffer> getProductOffer()
	{
		return productOfferService.getProductOffer(); 
	}	

}
