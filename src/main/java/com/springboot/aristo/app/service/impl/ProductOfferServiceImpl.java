package com.springboot.aristo.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.aristo.app.dao.ProductOfferDao;
import com.springboot.aristo.app.dto.ProductOffer;
import com.springboot.aristo.app.service.ProductOfferService;

@Service
public class ProductOfferServiceImpl implements ProductOfferService {
	
	@Autowired
	private ProductOfferDao productOfferDao;
	

	@Override
	public List<ProductOffer> getProductOffer() {
		// TODO Auto-generated method stub
		return productOfferDao.getProductOffer();
	}

}
