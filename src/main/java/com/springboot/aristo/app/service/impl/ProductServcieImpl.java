package com.springboot.aristo.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.aristo.app.dao.ProductDao;
import com.springboot.aristo.app.dto.Product;
import com.springboot.aristo.app.exception.ResourceNotFoundException;
import com.springboot.aristo.app.service.ProductService;

@Service
public class ProductServcieImpl implements ProductService {
	
	private ProductDao productDao;
	
	
	

	public ProductServcieImpl(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}


	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAllProducts();
	}
	
	@Override
	public Product getProductById(int id) {

		Product p = productDao.getProduct(id);
		if(p!=null)
			return productDao.getProduct(id);
		else
		{
			throw new ResourceNotFoundException("Product", "Id", id);
		}
		

	}


	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}


	@Override
	public Product updateProduct(Product product, int id) {

		Product prd = productDao.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Product", "id", id));

		prd.setName(product.getName());
		prd.setDescription(product.getDescription());
		prd.setPrice(product.getPrice());
		prd.setMrp(product.getMrp());
		prd.setImage(product.getImage());
		prd.setCategory(product.getCategory());

		productDao.save(prd);
		
		
		return (prd);
	}


	@Override
	public void deleteProduct(int id) {
		productDao.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Product", "id", id));
		productDao.deleteById(id);

		
	}
	




}
